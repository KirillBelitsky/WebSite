package servlets;

import database.DAO.ticket.TicketDAO;
import database.DAO.ticket.TicketMySQLDAO;
import database.DAO.user.UserDAO;
import database.DAO.user.UserMySQLDAO;
import entity.Ticket;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BookingServlet", urlPatterns = "/BookingServlet")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TicketDAO ticketDAO = new TicketMySQLDAO();
        ticketDAO.addTicket(fillTicket(req,resp));

    }

    private Ticket fillTicket(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Ticket ticket = new Ticket();
        HttpSession session = req.getSession();

        try {
            UserDAO userDAO = new UserMySQLDAO();

            ticket.setAirline(req.getParameter("airline"));
            ticket.setFlightNumber(Double.parseDouble(req.getParameter("flightNumber")));
            ticket.setDeparture_at(req.getParameter("departure_at"));
            ticket.setReturn_at(req.getParameter("return_at"));
            ticket.setPrice(Double.parseDouble(req.getParameter("price")));
            ticket.setUser_id(userDAO.getUser_Id((User) session.getAttribute("user")));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
        return ticket;
    }
}
