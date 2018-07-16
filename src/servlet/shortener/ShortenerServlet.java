package servlet.shortener;

import utils.Manager;
import utils.QueryBuilder;
import utils.Routes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "ShortenerServlet", urlPatterns = Routes.SHORTENER)
public class ShortenerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet ShortenerServlet");

        this.getServletContext().getRequestDispatcher("/shortener/shortener.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost ShortenerServlet");
        String url = request.getParameter("url");
        String whaturl = "1";

        if (!url.isEmpty()) {

            String secured = request.getParameter("secured");
            String password = request.getParameter("password");


            if (Manager.isUserValid(request, response)) {

                String captcha = request.getParameter("captcha");
                String click = request.getParameter("click");
                String nbclick = request.getParameter("nbclick");
                String daterange = request.getParameter("daterange");
                String startdate = request.getParameter("startdate");
                String enddate = request.getParameter("enddate");
                String datemax = request.getParameter("datemax");
                String maxdate = request.getParameter("maxdate");

                String emailUser = String.valueOf(request.getSession().getAttribute("email"));
                String passwordUser = String.valueOf(request.getSession().getAttribute("password"));


                Integer idUser = null;
                try {
                    idUser = Objects.requireNonNull(QueryBuilder.getIdUser(emailUser, passwordUser)).getInt(1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (secured != null && !password.isEmpty()) {
                    QueryBuilder.addURL(url, password);
                } else if (captcha != null) {
                    QueryBuilder.ComplexUrlData(url, idUser, "captcha");
                } else if (click != null && !nbclick.isEmpty()) {
                    QueryBuilder.ComplexUrlClick(url, idUser, "click", nbclick);
                } else if (daterange != null && !startdate.isEmpty() && !enddate.isEmpty()) {
                    QueryBuilder.ComplexUrlDateRange(url, idUser, "daterange", startdate, enddate);
                } else if (datemax != null && !maxdate.isEmpty()) {
                    QueryBuilder.ComplexUrlDateMax(url, idUser, "datemax", maxdate);
                } else {
                    QueryBuilder.addURL(url);
                }
            }
            else{

                if (secured != null && !password.isEmpty()) {
                    QueryBuilder.addURL(url, password);
                } else {
                    QueryBuilder.addURL(url);
                }
            }

            try {
                ResultSet lastURL = QueryBuilder.getLastURLResultSet();
                String short_url = Objects.requireNonNull(lastURL).getString(3);
                if (!password.isEmpty()) {
                    short_url += "?password=" + password;
                }
                request.getSession().setAttribute("short_url", short_url);

                request.getSession().setAttribute("flash_success", "URL raccourcie");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect(Routes.SHORTENER_RESULT);

            return;
        }

        request.getSession().setAttribute("flash_danger", "URL non remplie");
        response.sendRedirect("/");
    }
}
