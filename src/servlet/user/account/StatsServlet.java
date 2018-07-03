package servlet.user.account;

import org.json.JSONObject;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "StatsServlet", urlPatterns = Routes.USER_ACCOUNT_STATS)
public class StatsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Manager.isUserValid(request, response)) {
            return;
        }

        System.out.println("doGet StatsServlet");
        String id = getID(request);
        ResultSet resultSet = QueryBuilder.getUrlStatClickMaxOf15(Integer.parseInt(id));

        JSONObject tomJsonObj = new JSONObject();
        List<String> dates = new ArrayList<>();
        List<Integer> specific = new ArrayList<>();
        try {
            while (Objects.requireNonNull(resultSet).next()) {
                dates.add(resultSet.getString(1));
                specific.add(resultSet.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tomJsonObj.put("dates", dates);
        tomJsonObj.put("specific", specific);
        request.setAttribute("stats", tomJsonObj.toString());
        request.setAttribute("id", id);

        this.getServletContext().getRequestDispatcher("/user/account/stats.jsp").forward(request, response);
    }

    private String getID(HttpServletRequest request) {
        String[] splitted = request.getRequestURL().toString().split("/");

        return splitted[splitted.length - 1];
    }

}
