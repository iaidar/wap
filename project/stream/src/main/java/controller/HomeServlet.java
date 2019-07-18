package controller;

import model.Database;
import model.Video;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeServlet extends HttpServlet {
    List<Video> videos = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database db = new Database();
        this.videos = db.getVideos();
        req.setAttribute("videos", videos);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
