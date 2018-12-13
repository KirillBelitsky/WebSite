package database.DAO.ticket;

import entity.Ticket;

public interface TicketDAO {

    boolean addTicket(Ticket ticket);

    boolean findTicket(Ticket ticket);
}
