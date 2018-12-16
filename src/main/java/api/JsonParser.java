package api;

import tool.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public interface JsonParser {

    ArrayList<?> parse(String ... strings);

    static String converteStreamToString(BufferedReader is){
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
