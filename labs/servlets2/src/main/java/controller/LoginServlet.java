package controller;

import model.User;
import model.Userbase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",
        urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        StringBuilder page = new StringBuilder();
        if (Userbase.userExists(user)) {
            page.append("Secret page");
            if (request.getParameter("remember") != null) {
                Cookie usernameCookie = new Cookie("Username", username);
                usernameCookie.setMaxAge(60 * 60 * 24 * 30);//30 days
                response.addCookie(usernameCookie);
            } else {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals("Username")) {
                        cookie.setMaxAge(-1);
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
            Cookie promoCookie = new Cookie("Promo", "$100");
            promoCookie.setMaxAge(60 * 60 * 24 * 30);//30 days
            response.addCookie(promoCookie);

            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setMaxInactiveInterval(3600);
            response.sendRedirect("/secret_page");
        } else {
            page.append("<html><head><title>secret</title>");
            page.append("<h1>username or password incorrect!</h1>");
            page.append("<a href='login'>login</a>");
            page.append("</body></html>");
        }


        PrintWriter out = response.getWriter();
        out.print(page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String savedName = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("Username")) {
                savedName = cookie.getValue();
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("<html><head><title>login now</title>");
        result.append("<h1>Welcome</h1><form method='post' action='login'>");
        if (savedName != null) {
            result.append("<div><input type='text' name='username' value='" + savedName + "' required /></div>");
        } else {
            result.append("<div><input type='text' name='username' placeholder='Enter your Username' required /></div>");
        }
        result.append("<div><input type='password' name='password' placeholder='Enter your Password' required /></div>");
        if (savedName != null) {
            result.append("<div><label><input name='remember' type='checkbox' checked /> <span>Remember Me</span></label></div>");
        } else {
            result.append("<div><label><input name='remember' type='checkbox' /> <span>Remember Me</span></label></div>");
        }

        result.append("<div><input type='submit' value='login'/></div></form></body></html>");

        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
