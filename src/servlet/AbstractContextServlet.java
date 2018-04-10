package servlet;

import utils.ConfigHandler;
import utils.MySQL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;

abstract public class AbstractContextServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            MySQL mysql = new MySQL(getServletContext());
            mysql.connect();
            ConfigHandler.setDatabase(mysql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
