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

@WebServlet(name = "ChangePasswordServlet", urlPatterns = Routes.USER_ACCOUNT_CHANGE_PASSWORD)
public class ChangePasswordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Manager.isUserValid(request, response)) {
            return;
        }

        System.out.println("doGet ChangePasswordServlet");

        this.getServletContext().getRequestDispatcher("/user/account/change_password.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Manager.isUserValid(request, response)) {
            return;
        }

        System.out.println("doPost ChangePasswordServlet");
        String password_original = request.getParameter("password_original");
        String password_new = request.getParameter("password_new");
        String password_new_confirm = request.getParameter("password_new_confirm");

        if (!password_original.isEmpty() && !password_new.isEmpty() && !password_new_confirm.isEmpty()) {
            String email = (String) request.getSession().getAttribute("email");
            if (!QueryBuilder.isUserValid(email, password_original)) {
                request.getSession().setAttribute("flash_danger", "Mot de passe original non valide");
                response.sendRedirect(Routes.USER_ACCOUNT_CHANGE_PASSWORD);

                return;
            }

            if (!password_new.equals(password_new_confirm)) {
                request.getSession().setAttribute("flash_danger", "Nouveaux mots de passe non identiques");
                response.sendRedirect(Routes.USER_ACCOUNT_CHANGE_PASSWORD);

                return;
            }

            QueryBuilder.setUserPassword(email, password_original, password_new);

            request.getSession().setAttribute("flash_success", "Mot de passe mis à jour");
            response.sendRedirect(Routes.USER_ACCOUNT);
        }
    }
}
