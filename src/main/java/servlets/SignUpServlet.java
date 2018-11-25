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

        User user=fillingUser(req);

        try {
            UserDAO userDAO = new UserMySQLDAO();

            userDAO.addUser(user);
        }catch (SQLException e){}
        catch (PropertyVetoException ex){
            ex.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("front/jsp/authorisation/logIn.jsp");
        rd.forward(req,resp);
    }

    private User fillingUser(HttpServletRequest request){

        User user = new User(request.getParameter("sex"),request.getParameter("firstName"),
                request.getParameter("secondName"), request.getParameter("password"),request.getParameter("numberPhone"),
                request.getParameter("email"),request.getParameter("passport"),request.getParameter("city"),
                request.getParameter("indexCity"),request.getParameter("adress"),request.getParameter("datetime"));

        return user;
    }
}