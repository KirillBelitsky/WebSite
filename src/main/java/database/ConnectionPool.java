package database;

import java.sql.*;

public class ConnectionPool {
    Connection connection;

    public ConnectionPool() {
        try {
            System.out.println("1");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("232");
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Web_Site?" +
                            " autoReconnect = true & useSSL = false&serverTimezone=UTC",
                    "root", "28kir07");
        } catch (SQLException e) {
            System.out.println("34535");
        }
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }
}