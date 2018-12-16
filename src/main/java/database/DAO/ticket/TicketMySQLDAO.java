package database.DAO.ticket;

import database.DAO.user.UserDAO;
import database.Singleton;
import entity.Ticket;
import entity.User;

import java.sql.*;
import java.util.ArrayList;

public class TicketMySQLDAO implements TicketDAO {

    Singleton singleton = Singleton.getInstance();

    private static final String ADD_TICKET = "INSERT INTO Web_Site.Ticket (id_user,flightNumber,Airline,departureAt,returnAt,price)" +
            "VALUES ";
    private static final String FIND_TICKET = "SELECT * FROM Web_Site.Ticket WHERE ";
    private static final String GET_TICKETS = "SELECT * FROM Web_Site.Ticket WHERE ";
    private static final String REMOVE_TICKET = "DELETE FROM Web_Site.Ticket WHERE ";


    @Override
    public boolean addTicket(Ticket ticket) {


        StringBuilder query = new StringBuilder();
        query.append(String.format("('%s','%s','%s','%s','%s','%s');", ticket.getUser_id(), ticket.getFlightNumber(), ticket.getAirline(),
                ticket.getDeparture_at(), ticket.getReturn_at(), ticket.getPrice()));

        if (findTicket(ticket))
            return false;
        return process(ADD_TICKET + query);
    }

    @Override
    public boolean findTicket(Ticket ticket) {
        StringBuilder query = new StringBuilder();
        query.append(String.format("id_user='%s' AND price='%s' AND departureAt='%s' AND returnAt='%s' AND flightNumber='%s' AND airline='%s';", ticket.getUser_id(), ticket.getPrice(), ticket.getDeparture_at(),
                ticket.getReturn_at(), ticket.getFlightNumber(), ticket.getAirline()));

        try {
            Connection connection = singleton.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_TICKET + query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean removeTicket(Ticket ticket){
        StringBuilder query = new StringBuilder();
        query.append(String.format("Airline='%s' AND flightNumber='%s' AND price='%s' AND departureAt='%s' AND returnAt='%s';",
                ticket.getAirline(),ticket.getFlightNumber(),ticket.getPrice(),ticket.getDeparture_at(),ticket.getReturn_at()));

        return process(REMOVE_TICKET + query);
    }

    @Override
    public ArrayList<Ticket> getTickets(int id) {
        ArrayList<Ticket> list = new ArrayList<>();
        StringBuilder query = new StringBuilder();
        query.append(String.format("id_user='%s';",id));

        try{
            Connection connection = singleton.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_TICKETS + query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                int flightNumber = resultSet.getInt("flightNumber");
                String airline = resultSet.getString("Airline");
                String dep = resultSet.getString("departureAt");
                String ret = resultSet.getString("returnAt");
                Double price = resultSet.getDouble("price");

                list.add(new Ticket(flightNumber,airline,dep,ret,price));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private boolean process(String query){
        try{
            Connection connection = singleton.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            return statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
