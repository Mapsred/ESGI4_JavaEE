package servlet.shortener;

import entity.ComplexUrl;
import entity.Url;
import entity.UrlPassOption;
import utils.Manager;
import utils.QueryBuilder;
import utils.Routes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ShortenerVisitServlet", urlPatterns = Routes.SHORTENER_VISIT)
public class ShortenerVisitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet ShortenerVisitServlet");
        String short_url = getShortenedUrl(request);

        if (!QueryBuilder.isUrlExisting(short_url)) {
            this.invalid(request, response, "URL n'existe pas");

            return;
        }

        Url url = Objects.requireNonNull(QueryBuilder.findUrl(short_url));
        if (url.isExpired()) {
            this.invalid(request, response);

            return;
        }

        if (QueryBuilder.isPasswordProtected(url.getId())) {
            System.out.println("HasPassword");
            request.setAttribute("password", QueryBuilder.getPassword(url.getId()));

            this.getServletContext().getRequestDispatcher("/shortener/shortener_visit.jsp").forward(request, response);

            return;
        }

        if (QueryBuilder.isComplexUrl(url.getId())) {
            ComplexUrl complexUrl = Objects.requireNonNull(QueryBuilder.getComplexUrl(url.getId()));
            if (QueryBuilder.isUrlPassOption(complexUrl.getId())) {
                UrlPassOption urlPassOption = Objects.requireNonNull(QueryBuilder.getUrlPassOptions(complexUrl.getId()));
                request.setAttribute("url_pass_option", true);

                // Handle limit date (from => to) | Handle available_until
                if (!urlPassOption.isEnabled()) {
                    this.invalid(request, response);

                    return;
                }

                // Handle max click (see SQL url_stat)
                if (urlPassOption.isMaxClick(QueryBuilder.getUrlStatClick(url.getId()))) {
                    this.invalid(request, response, "Max click for this url");

                    return;
                }

                if (urlPassOption.getLibelle().equals("captcha") || urlPassOption.getLibelle().equals("password")) {
                    if (urlPassOption.getLibelle().equals("password")) {
                        System.out.println("HasPassword");
                        request.setAttribute("password", QueryBuilder.getPassword(url.getId()));
                    }

                    this.getServletContext().getRequestDispatcher("/shortener/shortener_visit.jsp").forward(request, response);

                    return;
                }
            }
        }

        QueryBuilder.addUrlStat(url.getId(), Manager.getClientIpAddr(request));

        this.redirect(url, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost ShortenerVisitServlet");
        String short_url = getShortenedUrl(request);

        if (!QueryBuilder.isUrlExisting(short_url)) {
            this.invalid(request, response, "URL n'existe pas");

            return;
        }

        Url url = Objects.requireNonNull(QueryBuilder.findUrl(short_url));
        if (url.isExpired()) {
            this.invalid(request, response);

            return;
        }

        if (QueryBuilder.isPasswordProtected(url.getId())) {
            System.out.println("HasPassword");

            String password = Objects.requireNonNull(QueryBuilder.getPassword(url.getId()));
            if (this.isPasswordInvalid(request, response, password)) {
                return;
            }

            this.redirect(url, response);
        }

        if (QueryBuilder.isComplexUrl(url.getId())) {
            ComplexUrl complexUrl = Objects.requireNonNull(QueryBuilder.getComplexUrl(url.getId()));
            if (QueryBuilder.isUrlPassOption(complexUrl.getId())) {
                UrlPassOption urlPassOption = Objects.requireNonNull(QueryBuilder.getUrlPassOptions(complexUrl.getId()));

                if (urlPassOption.getLibelle().equals("password")) {
                    String password = Objects.requireNonNull(QueryBuilder.getPassword(url.getId()));
                    if (this.isPasswordInvalid(request, response, password)) {
                        return;
                    }

                    this.redirect(url, response);
                }

                if (urlPassOption.getLibelle().equals("captcha")) {
                    //TODO HANDLE CAPTCHA POST

                    return;
                }
            }
        }

        this.redirect(url, response);
    }

    private String getShortenedUrl(HttpServletRequest request) {
        String[] splitted = request.getRequestURL().toString().split("/");

        return splitted[splitted.length - 1];
    }

    private void invalid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        invalid(request, response, "URL n'est plus valide");
    }

    private void invalid(HttpServletRequest request, HttpServletResponse response, String message) throws IOException {
        request.getSession().setAttribute("flash_danger", message);
        response.sendRedirect("/");
    }

    private void redirect(Url url, HttpServletResponse response) throws IOException {
        Pattern pattern = Pattern.compile("https?://");
        Matcher m = pattern.matcher(url.getBaseUrl());
        String redirectingUrl = m.find() ? url.getBaseUrl() : "http://" + url.getBaseUrl();

        response.sendRedirect(redirectingUrl);
    }

    private boolean isPasswordInvalid(HttpServletRequest request, HttpServletResponse response, String password) throws ServletException, IOException {
        if (!password.equals(request.getAttribute("password"))) {
            request.getSession().setAttribute("flash_danger", "Mot de passe invalide");
            this.getServletContext().getRequestDispatcher("/shortener/shortener_visit.jsp").forward(request, response);

            return true;
        }

        return false;
    }


}
