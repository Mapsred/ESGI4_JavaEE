package utils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Manager {
    /**
     * @param request HttpServletRequest
     * @return boolean
     */
    private static boolean isUserValid(HttpServletRequest request) {
        String username = String.valueOf(request.getSession().getAttribute("username"));
        String password = String.valueOf(request.getSession().getAttribute("password"));

        return QueryBuilder.isUserValid(username, password);
    }

    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @throws IOException from HttpServletRequest::sendRedirect
     */
    public static boolean isUserValid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!Manager.isUserValid(request)) {
            request.getSession().setAttribute("flash_danger", "Vous devez être connectés");
            response.sendRedirect("/login");

            return false;
        }

        return true;
    }

    /**
     * @param servletContext ServletContext
     * @param request       HttpServletRequest
     * @return boolean
     */
    private static boolean isUserValid(ServletContext servletContext, HttpServletRequest request) {
        String username = String.valueOf(request.getSession().getAttribute("username"));
        String password = String.valueOf(request.getSession().getAttribute("password"));

        return servletContext.getInitParameter("username").equals(username) &&
                servletContext.getInitParameter("password").equals(password);
    }

    /**
     * @param servletContext ServletContext
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     * @throws IOException from HttpServletRequest::sendRedirect
     */
    public static boolean isUserValid(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!Manager.isUserValid(servletContext, request)) {
            request.getSession().setAttribute("flash_danger", "Vous devez être connectés");
            response.sendRedirect("/login");

            return false;
        }

        return true;
    }
}
