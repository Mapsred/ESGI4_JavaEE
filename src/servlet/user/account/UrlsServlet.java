package servlet.user.account;

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

@WebServlet(name = "UrlsServlet", urlPatterns = Routes.USER_ACCOUNT_URLS)
public class UrlsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Manager.isUserValid(request, response)) {
            return;
        }

        System.out.println("doGet UrlsServlet");
        ResultSet resultSet = QueryBuilder.findUserUrls((String) request.getSession().getAttribute("email"));
        request.setAttribute("links", resultSet);

        this.getServletContext().getRequestDispatcher("/user/account/urls.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
