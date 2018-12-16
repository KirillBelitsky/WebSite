package api.Parser;

import api.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tool.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import java.net.URLEncoder;
import java.util.ArrayList;

import static constants.Constants.FIND_IATA;


public class JsonParserIataCity implements JsonParser {


    public ArrayList<?> parse(String ... strings){
        ArrayList<String> city = new ArrayList<>();

        String cityOne = strings[0];
        String cityTwo = strings[1];

        StringBuilder query = new StringBuilder();

        try {
            query.append(String.format("q=%s%s%s%s%s%s%s",URLEncoder.encode("Из","UTF-8"),"%20",URLEncoder.encode(cityOne,"UTF-8"),"%20",
                    URLEncoder.encode("в","UTF-8"),"%20",URLEncoder.encode(cityTwo,"UTF-8")));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }

        try {
            URL url = new URL(FIND_IATA + query);

            String resp = JsonParser.converteStreamToString(new BufferedReader(new InputStreamReader(url.openStream())));

            JSONObject jo = (JSONObject) new JSONParser().parse(resp);

            JSONObject origin = (JSONObject) jo.get("origin");
            if( origin == null)
                return null;

            String from = (String) origin.get("iata");

            JSONObject destination = (JSONObject) jo.get("destination");
            String to = (String) destination.get("iata");

            city.add(from);
            city.add(to);

            return city;
        }catch (MalformedURLException e){
            e.printStackTrace();
            return null;
        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }catch (ParseException exx){
            exx.printStackTrace();
            return null;
        }
    }
}
