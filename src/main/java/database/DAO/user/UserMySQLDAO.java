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
    private static final String ADD_USER = "INSERT INTO Web_Site.Users (sex,firstName,secondName," +
            "password,phoneNumber,email,numberPasport,city,cityIndex,adress,datetime) VALUES ";

    public UserMySQLDAO() throws IOException, SQLException, PropertyVetoException {

    }


    public boolean findUser(User user) {
        return false;
    }


    public ArrayList<User> getUsers() {

        ArrayList<User> list = new ArrayList<>();

        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USERS)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                list.add(new User(result.getInt("id"), result.getString("sex"), result.getString("FirstName"), result.getString("SecondName"),
                        result.getString("password"), result.getString("phoneNumber"), result.getString("email"), result.getString("numberPasport"),
                        result.getString("city"), result.getString("cityIndex"), result.getString("adress"), result.getString("datetime")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<User> getUsers(User user) {
        return null;
    }


    public boolean addUser(User user) {

        StringBuilder query = new StringBuilder();

        query.append(String.format("('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');",
                user.getSex(), user.getFirstName(), user.getSecondName(), user.getPassword(), user.getPhone(),
                user.getEmail(), user.getPassport(), user.getCity(), user.getPostIndex(), user.getAdress(), user.getDate()));

        try (Connection connection = pool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER + query);
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("User was not added!");
            return false;
        }
    }
}
