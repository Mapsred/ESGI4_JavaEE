package servlet.shortener;

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

        if (!url.isEmpty()) {

            String secured = request.getParameter("secured");
            String password = request.getParameter("password");

            String captcha = request.getParameter("captcha");
            String click = request.getParameter("click");
            String nbclick = request.getParameter("nbclick");
            String daterange = request.getParameter("daterange");
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");
            String datemax = request.getParameter("datemax");
            String maxdate = request.getParameter("maxdate");

            if (secured != null && !password.isEmpty()) {
                QueryBuilder.addURL(url, password);
            }
            else if(captcha != null){
                QueryBuilder.ComplexUrlData(url, "captcha");
            }
            else if(click != null && !nbclick.isEmpty()){
                QueryBuilder.ComplexUrlClick(url, "click", nbclick);
            }
            else if(daterange != null && !startdate.isEmpty() && !enddate.isEmpty()){
                QueryBuilder.ComplexUrlDateRange(url, "daterange", startdate, enddate);
            }
            else if(datemax != null && !maxdate.isEmpty()){
                QueryBuilder.ComplexUrlDateMax(url, "datemax", maxdate);
            }
            else{
                QueryBuilder.addURL(url);
            }

            try {
                ResultSet lastURL = QueryBuilder.getLastURLResultSet();
                String short_url = Objects.requireNonNull(lastURL).getString(2);
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
