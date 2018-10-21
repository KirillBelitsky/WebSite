package database.DAO.user;


import entity.User;
import java.util.ArrayList;

public interface UserDAO {

    boolean findUser(User user);

    ArrayList<User> getUsers();

    ArrayList<User> getUsers(User user);

    boolean addUsers(User... users);
}
