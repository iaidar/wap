package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/secret_page")
public class DashboardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder page = new StringBuilder();
        page.append("<html><head><title>Secret page</title>");
        page.append("<h1>Secret page</h1>");
        page.append("<a href='logout'>Logout</a>");
        page.append("</body></html>");

        PrintWriter out = response.getWriter();
        out.print(page);

    }
}
