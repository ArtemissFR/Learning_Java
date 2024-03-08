package com.votreentreprise.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.votreentreprise.models.User;

public class DatabaseUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/votreDB";
    private static final String JDBC_USER = "votreUtilisateur";
    private static final String JDBC_PASSWORD = "votreMotDePasse";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void addUser(User user) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (firstName, lastName, password) VALUES (?, ?, ?)")) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Gérez les exceptions correctement dans une application réelle
        }
    }

    public static List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gérez les exceptions correctement dans une application réelle
        }
        return userList;
    }
}
