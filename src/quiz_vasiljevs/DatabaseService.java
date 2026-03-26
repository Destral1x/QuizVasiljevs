/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz_vasiljevs;

import java.sql.*;

/**
 *
 * @author Glebs.Vasiljev
 */
public class DatabaseService {
     private static final String URL = "jdbc:derby://localhost:1527/QuizDBVasiljevs";
    private static final String USER = "userdb";
    private static final String PASS = "userdb";
    private Connection conn;

    public DatabaseService() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to Derby!");
        } catch (SQLException e) {
            System.out.println("DB error: " + e.getMessage());
        }
    }

    public User login(String login, String password) {
        String sql = "SELECT * FROM USERS WHERE LOGIN = ? AND PASSWORD = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String first = rs.getString("FIRST_NAME");
                String last = rs.getString("LAST_NAME");
                String role = rs.getString("ROLE");
                if (role.equals("admin")) {
                    return new Admin(id, first, last, login, password);
                } else {
                    return new Student(id, first, last, login, password);
                }
            }
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null;
    }

    public boolean addUser(String firstName, String lastName, String login, String password, String role) {
        String sql = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, login);
            ps.setString(4, password);
            ps.setString(5, role);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("addUser error: " + e.getMessage());
            return false;
        }
    }
}
