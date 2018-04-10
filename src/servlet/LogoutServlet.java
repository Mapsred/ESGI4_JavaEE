package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("password");
        request.getSession().setAttribute("flash_success", "Vous avez été déconnectés");

        response.sendRedirect("/login");
    }
}
