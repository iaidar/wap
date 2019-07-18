package controller;

import model.Database;
import model.Video;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class SingleVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Database db = new Database();
        Optional<Video> videoOp = db.getVideos().stream()
                                    .filter(v -> v.getId() == id)
                                    .findFirst();
        if(videoOp.isPresent()){
            request.setAttribute("video", videoOp.get()); }
        request.getRequestDispatcher("single_video.jsp").forward(request, response);
    }
}
