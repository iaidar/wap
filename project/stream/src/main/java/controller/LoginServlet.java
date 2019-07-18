package controller;

import model.Database;
import model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.HashSet;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    HashSet<User> users = new HashSet<>();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean remember = Boolean.parseBoolean(request.getParameter("remember"));



        Database db = new Database();
        this.users = db.getUsers();
        boolean exists = false;
        for (User user: users) {
            if(user.getPassword().equals(password) && user.getUsername().equals(username)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user.getId());
                exists = true;
            }
            // Remember the user using cookies
            if(remember) {
                Cookie c = new Cookie("user", ""+user.getId());
                c.setMaxAge(60*60*24);
                response.addCookie(c);
            } else {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals("user")) {
                        cookie.setMaxAge(-1);
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
        }
        if(!exists){
            request.setAttribute("err", "username or password incorrect");
            this.doGet(request, response);
        }
        else
            response.sendRedirect("/");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
