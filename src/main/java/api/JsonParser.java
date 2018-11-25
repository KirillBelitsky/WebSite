package api;

import entity.Ticket;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonParser {

    private static final String QUERY = "http://api.travelpayouts.com/v1/prices/cheap?origin=MOW&destination=HKT&depart_date=2019-01-03&return_date=2019-01-12&token=d8f72b4942d0e71a50aa037dba638429";

    private int count=0;

    public ArrayList<Ticket> parse() {

        ArrayList<Ticket> tickets = new ArrayList<>();

        try {


            URL url = new URL(QUERY);
            String resp = convertStreamToString(new BufferedReader(new InputStreamReader(url.openStream())));

            JSONObject jo = (JSONObject) new JSONParser().parse(resp);
            String currency = (String) jo.get("currency");
            JSONObject data = (JSONObject) jo.get("data");
            JSONObject hkt = (JSONObject) data.get("HKT");

            JSONObject array =(JSONObject) hkt.get(Integer.toString(count));

            while (array !=null) {
                count++;

                Long price = (Long) array.get("price");
                String airline = (String) array.get("airline");
                Long flightNumber = (Long) array.get("flight_number");
                String departure_at = (String) array.get("departure_at");
                String return_at = (String) array.get("return_at");
                String expires_at = (String) array.get("expires_at");

                tickets.add(new Ticket(price,flightNumber,airline,departure_at,return_at,expires_at));

                array = (JSONObject) hkt.get(Integer.toString(count));
            }

            for (Ticket x:tickets) {
                System.out.println(x.toString());
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
         catch (MalformedURLException ex) {
            return null;
        }catch (IOException e){return null;}
        return tickets;
    }
        private static String convertStreamToString (BufferedReader is){
            BufferedReader reader = is;
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }
}
