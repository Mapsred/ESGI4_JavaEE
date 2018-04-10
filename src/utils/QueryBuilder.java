package utils;

import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            String INSERT = "INSERT INTO `user` (`username`, `password`) VALUES (?, ?)";
            PreparedStatement query = ConfigHandler.getDatabase().prepare(INSERT);
            query.setString(1, user.getUsername());
            query.setString(2, user.getPassword());
            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
