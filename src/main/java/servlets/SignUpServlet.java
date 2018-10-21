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
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name="SignUpServlet",urlPatterns = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        processRequest(req,resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        try {
            UserDAO userDAO = new UserMySQLDAO();

            ArrayList<User> list=userDAO.getUsers();

            for (User x:list) {
                System.out.println(x.toString());
            }
        }catch (SQLException e){}
        catch (PropertyVetoException e){};

        RequestDispatcher rd = req.getRequestDispatcher("/front/jsp/first.jsp");
        rd.forward(req,resp);
    }
}