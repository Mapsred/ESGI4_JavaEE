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

@WebServlet(name = "ProfileServlet", urlPatterns = Routes.USER_ACCOUNT_PROFILE)
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Manager.isUserValid(request, response)) {
            return;
        }

        System.out.println("doGet ProfileServlet");
        int shortened_url = QueryBuilder.countComplexUrl((String) request.getSession().getAttribute("email"));
        request.setAttribute("shortened_url", shortened_url);

//        request.getSession().getAttribute("email")

        this.getServletContext().getRequestDispatcher("/user/account/profile.jsp").forward(request, response);
    }
}
