package servlet;

import utils.Routes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CgvServlet", urlPatterns = Routes.CGV)
public class CgvServlet extends HttpServlet {
    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet CGVServlet");

        this.getServletContext().getRequestDispatcher("/cgv.jsp").forward(request, response);
    }
}
