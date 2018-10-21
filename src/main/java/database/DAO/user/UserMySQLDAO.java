package database.DAO.user;

import database.ConnectionPool;
import entity.User;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class UserMySQLDAO implements UserDAO {

    ConnectionPool pool = new ConnectionPool();
    Connection connection;

    private static final String GET_USERS = "SELECT * FROM Web_Site.Users";

    public UserMySQLDAO() throws IOException, SQLException, PropertyVetoException{

    }


    public boolean findUser(User user) {
        return false;
    }


    public ArrayList<User> getUsers() {

        ArrayList<User> list = new ArrayList<>();

        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USERS)) {
            ResultSet result = statement.executeQuery();
            while (result.next()){
                list.add(new User(result.getInt("id"),result.getString("FirstName"),result.getString("SecondName"),result.getString("Userscol")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<User> getUsers(User user) {
        return null;
    }


    public boolean addUsers(User... users) {
        return false;
    }
}
