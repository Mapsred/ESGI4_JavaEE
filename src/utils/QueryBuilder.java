package utils;

import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class QueryBuilder {
    public static boolean isUserValid(String username, String password) {
        String SELECT = "SELECT * FROM `users` WHERE username = ? AND password = ?";
        try {
            PreparedStatement query = ConfigHandler.getDatabase().prepare(SELECT);
            query.setString(1, username);
            query.setString(2, password);

            ResultSet resultSet = query.executeQuery();
            return resultSet.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean isUserExisting(String username) {
        String SELECT = "SELECT * FROM `users` WHERE username = ?";
        try {
            PreparedStatement query = ConfigHandler.getDatabase().prepare(SELECT);
            query.setString(1, username);

            ResultSet resultSet = query.executeQuery();

            return resultSet.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void handleUser(User user) {
        try {
            String INSERT = "INSERT INTO `user` (`base_url`, `new_url`, `created_at`, `deleted_at`) VALUES (?, ?)";
            PreparedStatement query = ConfigHandler.getDatabase().prepare(INSERT);
            query.setString(1, user.getUsername());
            query.setString(2, user.getPassword());
            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getLastURLResultSet() {
        try {
            String SELECT = "SELECT * FROM `simple_url` ORDER BY `id` DESC";
            PreparedStatement query = ConfigHandler.getDatabase().prepare(SELECT);
            ResultSet resultSet = query.executeQuery();

            resultSet.first();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void addURL(String url) {
        try {
            String INSERT = "INSERT INTO `simple_url` (`base_url`, `new_url`, `created_at`, `deleted_at`) VALUES (?, ?, ?, ?)";
            PreparedStatement query = ConfigHandler.getDatabase().prepare(INSERT);

            query.setString(1, url);
            query.setString(2, url); //TODO CREATE NEW URL

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();

            calendar.setTime(new Date());
            query.setString(3, format.format(calendar.getTime()));

            calendar.add(Calendar.MONTH, 6);
            query.setString(4, format.format(calendar.getTime()));

            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addURL(String url, String password) {
        try {
            QueryBuilder.addURL(url);
            int lastURL = Objects.requireNonNull(QueryBuilder.getLastURLResultSet()).getInt(1);

            String INSERT = "INSERT INTO `password` (`url`, `password`) VALUES (?, ?)";
            PreparedStatement query = ConfigHandler.getDatabase().prepare(INSERT);
            query.setInt(1, lastURL);
            query.setString(2, password);

            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
