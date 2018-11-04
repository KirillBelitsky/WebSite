package servlets;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.security.sasl.AuthenticationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONObject;

@WebServlet(name="MyServlet",urlPatterns = "/MyServlet")
public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpURLConnection connection = null;
        URL url = new URL("http://api.travelpayouts.com/v1/prices/cheap?origin=MOW&destination=HKT&depart_date=2018-11&return_date=2018-12&currency=USD&token=d8f72b4942d0e71a50aa037dba638429");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "application/json");

        connection.setUseCaches(false);
        connection.setDoOutput(true);
        //Send request
        DataOutputStream wr = new DataOutputStream(
                connection.getOutputStream());

        wr.close();

        //Get Response
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder resp = new StringBuilder(); // or StringBuffer if Java version 5+
        String line;
        while ((line = rd.readLine()) != null) {
            resp.append(line);
            resp.append('\r');
        }
        rd.close();
        System.out.println(resp.toString());

//        JSONObject jObject = new JSONObject(result);
//        String error = jObject.getString("currency");
//        System.out.println(error);

    }
}