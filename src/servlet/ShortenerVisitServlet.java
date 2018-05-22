package servlet;

import entity.ComplexUrl;
import entity.Url;
import entity.UrlPassOption;
import utils.QueryBuilder;
import utils.Routes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "ShortenerVisitServlet", urlPatterns = Routes.SHORTENER_VISIT)
public class ShortenerVisitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet ShortenerVisitServlet");
        String short_url = getShortenedUrl(request);

        if (!QueryBuilder.isUrlExisting(short_url)) {
            request.getSession().setAttribute("flash_danger", "URL n'existe pas");
            response.sendRedirect("/");
        }

        Url url = Objects.requireNonNull(QueryBuilder.findUrl(short_url));
        System.out.println(url.toString());

        if (url.isExpired()) {
            request.getSession().setAttribute("flash_danger", "URL n'est plus valide");
            response.sendRedirect("/");

            return;
        }

        if (QueryBuilder.isPasswordProtected(url.getId())) {
            request.setAttribute("password", QueryBuilder.getPassword(url.getId()));

            this.getServletContext().getRequestDispatcher("/shortener_visit.jsp").forward(request, response);
            return;
        }

        if (QueryBuilder.isComplexUrl(url.getId())) {
            ComplexUrl complexUrl = Objects.requireNonNull(QueryBuilder.getComplexUrl(url.getId()));
            if (QueryBuilder.isUrlPassOption(complexUrl.getId())) {
                UrlPassOption urlPassOption = QueryBuilder.getUrlPassOptions(complexUrl.getId());
                request.setAttribute("url_pass_option", true);
            }

            this.getServletContext().getRequestDispatcher("/shortener_visit.jsp").forward(request, response);
            return;
        }


        //TODO Fetch complex_url / if defined fetch url_pass_option
        response.sendRedirect(url.getBaseUrl());
    }

    private String getShortenedUrl(HttpServletRequest request) {
        String[] splitted = request.getRequestURL().toString().split("/");

        return splitted[splitted.length - 1];
    }

}
