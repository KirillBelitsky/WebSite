package database.DAO.user;


import entity.User;
import java.util.ArrayList;

public interface UserDAO {

    boolean findUserTrue(User user);

    User findUser(User user);

    ArrayList<User> getUsers();

    ArrayList<User> getUsers(User user);

    boolean addUser(User user);
}
