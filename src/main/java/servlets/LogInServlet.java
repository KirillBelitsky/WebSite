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

                httpSession.setAttribute("user",userDAO.findUser(user));
                httpSession.setAttribute("phone","+375"+userDAO.findUser(user).getPhone());
                httpSession.setAttribute("email",userDAO.findUser(user).getEmail());
                httpSession.setAttribute("country",userDAO.findUser(user).getCity());
                httpSession.setAttribute("name",userDAO.findUser(user).getFirstName());
                System.out.println(req.getParameter("url"));

                if(req.getParameter("url")!=null)
                    resp.sendRedirect(req.getParameter("url"));

                resp.sendRedirect("/index.jsp");
            }
            else {
                resp.sendRedirect("/front/jsp/authorisation/logIn.jsp");
            }
    }catch (SQLException e){}
    catch (PropertyVetoException ex){}

    }
}