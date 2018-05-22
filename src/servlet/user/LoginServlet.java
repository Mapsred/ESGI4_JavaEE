package servlet.user;

import utils.Routes;
import utils.QueryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = Routes.LOGIN)
public class LoginServlet extends HttpServlet {
    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet LoginServlet");

        this.getServletContext().getRequestDispatcher("/user/login.jsp").forward(request, response);
    }

    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost LoginServlet");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (!email.isEmpty() && !password.isEmpty()) {
            if (!QueryBuilder.isUserValid(email, password)) {
                request.getSession().setAttribute("flash_danger", "Utilisateur non valide");
                response.sendRedirect(Routes.LOGIN);

                return;
            }
            request.getSession().setAttribute("flash_success", "Utilisateur valide");
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);

            response.sendRedirect("/");

            return;
        }

        request.getSession().setAttribute("flash_danger", "Utilisateur non rempli");
        response.sendRedirect(Routes.LOGIN);
    }

}
