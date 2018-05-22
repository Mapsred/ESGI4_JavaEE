package servlet;

import utils.Routes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PartnerServlet", urlPatterns = Routes.PARTNER)
public class PartnerServlet extends HttpServlet {
    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet PartnerServlet");

        this.getServletContext().getRequestDispatcher("/partner.jsp").forward(request, response);
    }
}
