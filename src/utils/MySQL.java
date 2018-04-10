package utils;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MySQL {
    private String hostname;
    private int port;
    private String dbname;
    private String username;
    private String password;

    private Connection connection;

    public MySQL() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Properties config = ConfigHandler.getStaticConfig();
            this.setDbname(config.getProperty("dbname"))
                    .setHostname(config.getProperty("hostname"))
                    .setPassword(config.getProperty("password"))
                    .setPort(Integer.parseInt(config.getProperty("port")))
                    .setUsername(config.getProperty("username"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public MySQL(ServletContext servletContext) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.setDbname(servletContext.getInitParameter("mysql_dbname"))
                .setHostname(servletContext.getInitParameter("mysql_hostname"))
                .setPassword(servletContext.getInitParameter("mysql_password"))
                .setPort(Integer.parseInt(servletContext.getInitParameter("mysql_port")))
                .setUsername(servletContext.getInitParameter("mysql_username"));
    }

    /**
     * @return String
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname String
     * @return MySQL
     */
    public MySQL setHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    /**
     * @return int
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port int
     * @return MySQL
     */
    public MySQL setPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * @return String
     */
    public String getDbname() {
        return dbname;
    }

    /**
     * @param dbname String
     * @return MySQL
     */
    public MySQL setDbname(String dbname) {
        this.dbname = dbname;
        return this;
    }

    /**
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username String
     * @return MySQL
     */
    public MySQL setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password String
     * @return MySQL
     */
    public MySQL setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * @return Connection
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * @return String
     */
    public String toString() {
        return "Mysql(host=" + this.getHostname() + ", port=" + this.getPort() + ", database=" + this.getDbname() +
                ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", autoReconnect=true" +
                ", connection=" + this.getConnection() + ")";
    }

    /**
     * @throws SQLException           SQL Exception
     */
    public void connect() throws SQLException {
        String url = "jdbc:mysql://"+this.getHostname()+":"+this.getPort()+"/"+this.getDbname();
        this.connection = DriverManager.getConnection(url, this.getUsername(), this.getPassword());
    }

    /**
     * @param query String
     * @return Statement
     * @throws SQLException SQL Exception
     */
    public Statement query(String query) throws SQLException {
        return this.getConnection().createStatement();
    }

    /**
     * @param query String
     * @return PrepareStatement
     * @throws SQLException SQL Exception
     */
    public PreparedStatement prepare(String query) throws SQLException {
        return this.getConnection().prepareStatement(query);
    }

}
