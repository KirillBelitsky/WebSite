package filters.securityFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/front/jsp/withAuthorisation/")
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        if(session.getAttribute("user")==null){
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/front/jsp/authorisation/logIn.jsp");
            dispatcher.forward(req,resp);
        }
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
    }
}
