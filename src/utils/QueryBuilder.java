package utils;

import entity.ComplexUrl;
import entity.Url;
import entity.UrlPassOption;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class QueryBuilder {
    public static boolean isUserValid(String email, String password) {
        String SELECT = "SELECT * FROM `users` WHERE email = ? AND password = ?";
        try {
            PreparedStatement query = ConfigHandler.getDatabase().prepare(SELECT);
            query.setString(1, email);
            query.setString(2, password);

            ResultSet resultSet = query.executeQuery();
            return resultSet.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean isUserExisting(String email) {
        String SELECT = "SELECT * FROM `users` WHERE email = ?";

        return QueryBuilder.isEntryExisting(SELECT, email);
    }

    public static void handleUser(User user) {
        try {
            String INSERT = "INSERT INTO `user` (`email`, `password`, `pro_status`, `enabled`) VALUES (?, ?)";
            PreparedStatement query = ConfigHandler.getDatabase().prepare(INSERT);
            query.setString(1, user.getEmail());
            query.setString(2, user.getPassword());
            query.setString(3, user.getStatus());
            query.setInt(4, 1);
            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getLastURLResultSet() {
        try {
            String SELECT = "SELECT * FROM `simple_url` ORDER BY `id` DESC";
            PreparedStatement query = ConfigHandler.getDatabase().prepare(SELECT);

            return QueryBuilder.findOne(query);
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


    public static boolean isUrlExisting(String short_url) {
        String SELECT = "SELECT * FROM `simple_url` WHERE new_url = ?";

        return isEntryExisting(SELECT, short_url);
    }

    public static Url findUrl(String short_url) {
        String SELECT = "SELECT * FROM `simple_url` WHERE new_url = ? ORDER BY `id` DESC";
        try {
            PreparedStatement query = ConfigHandler.getDatabase().prepare(SELECT);
            query.setString(1, short_url);
            ResultSet resultSet = QueryBuilder.findOne(query);

            return new Url(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static boolean isPasswordProtected(int url_id) {
        String SELECT = "SELECT * FROM `password` WHERE url = ?";

        return isEntryExisting(SELECT, String.valueOf(url_id));
    }

    public static String getPassword(int url_id) {
        String SELECT = "SELECT * FROM `password` WHERE url = ?";

        try {
            ResultSet resultSet = QueryBuilder.findOneById(SELECT, url_id);

            return Objects.requireNonNull(resultSet).getString(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static boolean isComplexUrl(int url_id) {
        String SELECT = "SELECT * FROM `complex_url` WHERE simple_id = ?";

        return isEntryExisting(SELECT, String.valueOf(url_id));
    }

    public static ComplexUrl getComplexUrl(int url_id) {
        String SELECT = "SELECT * FROM `complex_url` WHERE simple_id = ?";

        ResultSet resultSet = Objects.requireNonNull(QueryBuilder.findOneById(SELECT, url_id));

        try {
            return new ComplexUrl(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static boolean isUrlPassOption(int url_complex_id) {
        String SELECT = "SELECT * FROM `url_pass_option` WHERE url_complex_id = ?";

        return isEntryExisting(SELECT, String.valueOf(url_complex_id));
    }

    public static UrlPassOption getUrlPassOptions(int url_complex_id) {
        String SELECT = "SELECT * FROM `url_pass_option` WHERE url_complex_id = ?";

        ResultSet resultSet = Objects.requireNonNull(QueryBuilder.findOneById(SELECT, url_complex_id));

        try {
            return new UrlPassOption(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }


    public static void addUrlStat(int url_id, String ip) {
        try {
            String INSERT = "INSERT INTO `url_stat` (`url_id`, `date`, `ip`) VALUES (?, ?, ?)";
            PreparedStatement query = ConfigHandler.getDatabase().prepare(INSERT);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());

            query.setInt(1, url_id);
            query.setString(2, format.format(calendar.getTime()));
            query.setString(3, ip);

            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int getUrlStatClick(int url_id) {
        String SELECT = "SELECT COUNT(*) FROM url_stat WHERE url_id = ?";
        try {
            PreparedStatement query = ConfigHandler.getDatabase().prepare(SELECT);
            query.setInt(1, url_id);
            ResultSet resultSet = query.executeQuery();

            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }


    private static boolean isEntryExisting(String SELECT, String parameter) {
        try {
            PreparedStatement query = ConfigHandler.getDatabase().prepare(SELECT);
            query.setString(1, parameter);

            ResultSet resultSet = query.executeQuery();

            return resultSet.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    private static ResultSet findOneById(String SELECT, int id) {
        try {
            PreparedStatement query = ConfigHandler.getDatabase().prepare(SELECT);
            query.setInt(1, id);

            return QueryBuilder.findOne(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static ResultSet findOne(PreparedStatement query) throws SQLException {
        ResultSet resultSet = query.executeQuery();
        resultSet.first();

        return resultSet;
    }
}
