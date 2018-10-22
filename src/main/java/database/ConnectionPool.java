package database;

import java.sql.*;

import static constants.Constants.driver;
import static constants.Constants.host;
import static constants.Constants.login;
import static constants.Constants.password;

public class ConnectionPool {
    Connection connection;

    public ConnectionPool() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is Driver?");
        }
        try {
            connection = DriverManager.getConnection(host +
                            " autoReconnect = true & useSSL = false&serverTimezone=UTC",
                    login, password);
        } catch (SQLException e) {
            System.out.println("Where is my connection?");
        }
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }
}