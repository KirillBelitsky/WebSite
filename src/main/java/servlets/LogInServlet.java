package servlets;

import database.DAO.user.UserDAO;
import database.DAO.user.UserMySQLDAO;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="LogIn",urlPatterns = "/LogInServlet")
public class LogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        User user = new User();
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        user.setEmail(email);
        user.setPassword(password);

        try {
            UserDAO userDAO = new UserMySQLDAO();

            if(userDAO.findUserTrue(user)){

                httpSession.setAttribute("status","user");
                httpSession.setAttribute("user",userDAO.findUser(user).getEmail());
                httpSession.setAttribute("name",userDAO.findUser(user).getSecondName() + userDAO.findUser(user).getFirstName());
                httpSession.setAttribute("phone",userDAO.findUser(user).getPhone());
                httpSession.setAttribute("country","Belarus," + userDAO.findUser(user).getCity());

                resp.sendRedirect("/index.jsp");
            }
            else {
                resp.sendRedirect("/front/jsp/authorisation/logIn.jsp");
            }
    }catch (SQLException e){}
    catch (PropertyVetoException ex){}

    }
}