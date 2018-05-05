package servlet;

import utils.Routes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Routes.SHORTENER_RESULT)
public class ShortenerResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet ShortenerResultServlet");

        String shortUrl = (String) request.getSession().getAttribute("short_url");
        if (shortUrl.isEmpty()) {
            request.getSession().setAttribute("flash_danger", "URL non remplie");
            response.sendRedirect(Routes.SHORTENER);

            return;
        }

        String[] parts = shortUrl.split("\\?password=");
        if (parts.length > 1) {
            request.setAttribute("short_password", parts[1]);
        }

        request.setAttribute("short_url", parts[0]);
        request.setAttribute("full_url", shortUrl);

        this.getServletContext().getRequestDispatcher("/shortener_result.jsp").forward(request, response);
    }
}
