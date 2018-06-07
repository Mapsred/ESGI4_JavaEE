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
import java.sql.ResultSet;

@WebServlet(name = "StatsServlet", urlPatterns = Routes.USER_ACCOUNT_STATS)
public class StatsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Manager.isUserValid(request, response)) {
            return;
        }

        System.out.println("doGet StatsServlet");
        String id = getID(request);
        ResultSet resultSet = QueryBuilder.getUrlStatClick(Integer.parseInt(id));
        request.setAttribute("stats", resultSet);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String getID(HttpServletRequest request) {
        String[] splitted = request.getRequestURL().toString().split("/");

        return splitted[splitted.length - 1];
    }

}
