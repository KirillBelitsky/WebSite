package database.DAO.ticket;

import database.DAO.user.UserDAO;
import database.Singleton;
import entity.Ticket;
import entity.User;

import java.sql.*;

public class TicketMySQLDAO implements TicketDAO {

    Singleton singleton = Singleton.getInstance();

    private static final String ADD_TICKET = "INSERT INTO Web_Site.Ticket (id_user,flightNumber,Airline,departureAt,returnAt,price)" +
            "VALUES ";
    private static final String FIND_TICKET = "SELECT * FROM Web_Site.Ticket WHERE ";


    @Override
    public boolean addTicket(Ticket ticket) {


        StringBuilder query = new StringBuilder();
        query.append(String.format("('%s','%s','%s','%s','%s','%s');",ticket.getUser_id(),ticket.getFlightNumber(),ticket.getAirline(),
                ticket.getDeparture_at(),ticket.getReturn_at(),ticket.getPrice()));

        try{
            Connection connection = singleton.getConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_TICKET + query);

            return statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean findTicket(Ticket ticket) {
        StringBuilder query = new StringBuilder();
        query.append(String.format("price='%s' AND departureAt='%s' AND returnAt='%s' AND flightNumber='%s';", ticket.getPrice(), ticket.getDeparture_at(),
                ticket.getReturn_at(), ticket.getFlightNumber()));

        try{
            Connection connection = singleton.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_TICKET + query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
