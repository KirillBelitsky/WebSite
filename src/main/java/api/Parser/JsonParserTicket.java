package api.Parser;

import entity.Ticket;
import api.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tool.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static constants.Constants.FIND_TICKETS;
import static constants.Constants.TOKEN;


public class JsonParserTicket implements JsonParser {

    private int count=0;

    public Result parse(String ... temp) {

        ArrayList<Ticket> tickets = new ArrayList<>();

        ArrayList<?> iata = new JsonParserIataCity().parse(temp[0],temp[1]).getList();

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("origin=%s&destination=%s&depart_date=%s&return_date=%s&currency=USD&" + TOKEN,iata.get(0),iata.get(1),temp[2],temp[3]));

            System.out.println(FIND_TICKETS + sb);

            URL url = new URL(FIND_TICKETS + sb);
            String resp = JsonParser.converteStreamToString(new BufferedReader(new InputStreamReader(url.openStream())));

            JSONObject jo = (JSONObject) new JSONParser().parse(resp);
            JSONObject data = (JSONObject) jo.get("data");
            JSONObject city= (JSONObject) data.get(iata.get(1));

            if(city == null)
                return new Result(null);

            JSONObject array =(JSONObject) city.get(Integer.toString(count));

            while (array !=null) {
                count++;

                Long price = (Long) array.get("price");
                String airline = (String) array.get("airline");
                Long flightNumber = (Long) array.get("flight_number");
                String departure_at = (String) array.get("departure_at");
                String return_at = (String) array.get("return_at");

                tickets.add(new Ticket(flightNumber,airline,separate(departure_at),separate(return_at),Double.valueOf(price)));

                array = (JSONObject) city.get(Integer.toString(count));
            }

        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }catch (MalformedURLException ex) {
            return null;
        }catch (IOException e){return null;}

        return new Result(tickets);
    }

    private String separate(String temp){
        return new String(temp.substring(0,temp.indexOf("T")) + " " + temp.substring(temp.indexOf("T")+1,temp.length()-1));
    }
}
