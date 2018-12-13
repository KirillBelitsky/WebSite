package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static constants.Constants.*;

public final class Singleton {

    private static Singleton instance;
    private Connection connection;

    private Singleton(){
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

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        return instance.connection;
    }
}
