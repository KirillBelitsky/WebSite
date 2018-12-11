package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;

import api.Parser.JsonParserTicket;


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

        String cityFrom = request.getParameter("city_from");
        String cityTo =  request.getParameter("city_to");
        String departure_at = request.getParameter("departure_at");
        String return_at =request.getParameter("return_at");


        ArrayList<?> tickets = new JsonParserTicket().parse(cityFrom,cityTo,departure_at,return_at).getList();
        if(tickets!=null)
            System.out.println(tickets.toString());

        HttpSession session = request.getSession();
        session.setAttribute("tickets",tickets);

        request.getRequestDispatcher("front/jsp/pages/bookingTickets.jsp").forward(request,response);
    }
}