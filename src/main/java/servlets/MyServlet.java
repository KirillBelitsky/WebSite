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
import java.io.IOException;

import feadback.GMailSender;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        super.doGet(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String emails = request.getParameter("footer_form_email");
        String text = request.getParameter("footer_form_text");


        RequestDispatcher rd=request.getRequestDispatcher("front/jsp/first.jsp");
        rd.forward(request,response);
    }
}