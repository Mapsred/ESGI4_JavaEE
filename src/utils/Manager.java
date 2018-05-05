package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Manager {
    /**
     * @param request HttpServletRequest
     * @return boolean
     */
    private static boolean isUserValid(HttpServletRequest request) {
        String email = String.valueOf(request.getSession().getAttribute("email"));
        String password = String.valueOf(request.getSession().getAttribute("password"));

        return QueryBuilder.isUserValid(email, password);
    }

    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @throws IOException from HttpServletRequest::sendRedirect
     */
    public static boolean isUserValid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (Manager.isUserValid(request)) {
            request.getSession().setAttribute("flash_danger", "Vous devez être connectés");
            response.sendRedirect("/login");

            return true;
        }

        return false;
    }
}
