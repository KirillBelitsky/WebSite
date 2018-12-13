package entity;

public class Ticket {

    private double price;
    private double flightNumber;
    private String airline;
    private String departure_at;
    private String return_at;
    private int user_id;

    public Ticket(int id_user, double flightNumber, String airline, String departure_at, String return_at, double price) {
        this.price = price;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departure_at = departure_at;
        this.return_at = return_at;
        this.user_id = id_user;
    }

    public Ticket() {
    }

    public Ticket(double flightNumber, String airline, String departure_at, String return_at,double price) {
        this.price = price;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departure_at = departure_at;
        this.return_at = return_at;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(double flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDeparture_at() {
        return departure_at;
    }

    public void setDeparture_at(String departure_at) {
        this.departure_at = departure_at;
    }

    public String getReturn_at() {
        return return_at;
    }

    public void setReturn_at(String return_at) {
        this.return_at = return_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int id) {
        this.user_id = id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "price=" + price +
                ", flightNumber=" + flightNumber +
                ", airline='" + airline + '\'' +
                ", departure_at='" + departure_at + '\'' +
                ", return_at='" + return_at + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}


