package database.DAO.ticket;

import entity.Ticket;

import java.util.ArrayList;

public interface TicketDAO {

    boolean addTicket(Ticket ticket);

    boolean findTicket(Ticket ticket);

    ArrayList<Ticket> getTickets(int id);
}
