package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/legalnotice")
public class LegalnoticeServlet extends HttpServlet {
    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet LegalNoticeServlet");

        this.getServletContext().getRequestDispatcher("/legalnotice.jsp").forward(request, response);
    }
}
