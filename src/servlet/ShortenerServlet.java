package servlet;

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

@WebServlet(Routes.SHORTENER)
public class ShortenerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet ShortenerServlet");

        this.getServletContext().getRequestDispatcher("/shortener.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost ShortenerServlet");
        String url = request.getParameter("url");

        if (!url.isEmpty()) {
            String secured = request.getParameter("secured");
            String password = request.getParameter("password");

            if (secured != null && !password.isEmpty()) {
                QueryBuilder.addURL(url, password);
            } else {
                QueryBuilder.addURL(url);
            }

            try {
                ResultSet lastURL = QueryBuilder.getLastURLResultSet();
                String short_url = Objects.requireNonNull(lastURL).getString(2);
                request.getSession().setAttribute("flash_success", "URL raccourcie : " + short_url);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("/");

            return;
        }

        request.getSession().setAttribute("flash_danger", "URL non remplie");
        response.sendRedirect("/");
    }
}
