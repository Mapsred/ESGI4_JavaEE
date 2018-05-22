package servlet.user;

import entity.User;
import utils.Routes;
import utils.QueryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = Routes.REGISTER)
public class RegisterServlet extends HttpServlet {
    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet RegisterServlet");

        this.getServletContext().getRequestDispatcher("/user/register.jsp").forward(request, response);
    }

    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost RegisterServlet");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_second = request.getParameter("password_second");
        String status = request.getParameter("status");

        if (!email.isEmpty() && !password.isEmpty() && !password_second.isEmpty()) {
            if (!password.equals(password_second)) {
                request.getSession().setAttribute("flash_warning", "Les deux mots de passe doivent être identiques");
                response.sendRedirect(Routes.REGISTER);

                return;
            }

            if (QueryBuilder.isUserExisting(email)) {
                request.getSession().setAttribute("flash_warning", "L'utilisateur existe déjà");
                response.sendRedirect(Routes.REGISTER);

                return;
            }

            User user = new User(email, password, status);
            QueryBuilder.handleUser(user); // Add the user to the database
            request.getSession().setAttribute("flash_success", "Mail de confirmation envoyé"); //TODO CREATE AND SEND AN EMAIL
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);

            response.sendRedirect("/");

            return;
        }

        request.getSession().setAttribute("flash_danger", "Champs non remplis");
        response.sendRedirect(Routes.REGISTER);
    }

}
