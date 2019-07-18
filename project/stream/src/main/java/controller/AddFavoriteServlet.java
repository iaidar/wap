package controller;

import model.Database;
import model.Favorite;
import model.User;
import model.Video;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "AddFavoriteServlet")
public class AddFavoriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database db = new Database();

        long videoId = Long.parseLong(request.getParameter("videoId"));
        long userId = (long) request.getSession().getAttribute("user");

        Video video = db.getVideos().stream()
                .filter(v -> v.getId() == videoId).findFirst().get();

        User user = db.getUsers().stream()
                .filter(u -> u.getId() == userId).findFirst().get();

        Favorite f = new Favorite(user, video);

        int added = user.addFavorite(f); // return -1 if it is already exists
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(""+added);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database db = new Database();
        long userId = (long) request.getSession().getAttribute("user");
        User user = db.getUsers().stream()
                .filter(u -> u.getId() == userId).findFirst().get();

        List<Video> videos = user.getFavorites().stream()
                                            .map(fav -> fav.getVideo())
                                            .collect(Collectors.toList());
        request.setAttribute("videos", videos);
        request.setAttribute("fav", 1);
        request.getRequestDispatcher("favorites.jsp").forward(request, response);
    }
}
