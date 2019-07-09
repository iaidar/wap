import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SupportServlet", urlPatterns = {"/contact"})
public class SupportServlet extends HttpServlet {
    private static int ticket_id = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ticket_id++;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contact.jsp");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        ServletContext sc = this.getServletContext();
        String spportEmail = sc.getInitParameter("support-email");
        String msg = "Thank you! " + name +" for contacting us. We should receive reply from us with in 24 hrs in your email " +
                "address " + email + ". Let us know in our support email "+ spportEmail +" if you don’t receive reply within 24 hrs. " +
                "Please be sure to attach your reference "+ ticket_id +" in your email.";
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().println("<html>"
//                + "<head><title>Contact us</title></head>"
//                + "<body bgcolor = \\\"#f0f0f0\\\">"
//                +"</body>");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contact.jsp");

        requestDispatcher.forward(request, response);
    }
}
