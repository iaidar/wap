package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Database {
     HashSet<User> users = new HashSet<User>();
     List<Video> videos = new ArrayList<Video>();

    public Database() {
        users.add(new User(1,"user1", "123"));
        users.add(new User(2,"user2", "123"));

        videos.add(new Video(1, "lorem yaw1", "nice video, you better watch it!", "http://ericmaddox.com/wp-content/uploads/2016/06/Youtube-Icon.png", "https://www.youtube.com/embed/NVwpGYo0zc8"));
        videos.add(new Video(2, "lorem yaw2", "nice video, you better watch it!", "http://ericmaddox.com/wp-content/uploads/2016/06/Youtube-Icon.png", "https://www.youtube.com/embed/EZp40eoNzDA"));
        videos.add(new Video(3, "lorem yaw3", "nice video, you better watch it!", "http://ericmaddox.com/wp-content/uploads/2016/06/Youtube-Icon.png", "https://www.youtube.com/embed/Xg2JdbLOHyA"));
        videos.add(new Video(4, "lorem yaw4", "nice video, you better watch it!", "http://ericmaddox.com/wp-content/uploads/2016/06/Youtube-Icon.png", "https://www.youtube.com/watch?v=mNLTMgZKxDU"));
        videos.add(new Video(5, "lorem yaw5", "nice video, you better watch it!", "http://ericmaddox.com/wp-content/uploads/2016/06/Youtube-Icon.png", "https://www.youtube.com/watch?v=3PgtFy1I6Kk"));
        videos.add(new Video(6, "lorem yaw6", "nice video, you better watch it!", "http://ericmaddox.com/wp-content/uploads/2016/06/Youtube-Icon.png", "https://www.youtube.com/watch?v=m193PnSMUw8"));
        videos.add(new Video(7, "lorem yaw7", "nice video, you better watch it!", "http://ericmaddox.com/wp-content/uploads/2016/06/Youtube-Icon.png", "https://www.youtube.com/watch?v=OPB74hALCSM"));
        videos.add(new Video(8, "lorem yaw8", "nice video, you better watch it!", "http://ericmaddox.com/wp-content/uploads/2016/06/Youtube-Icon.png", "https://www.youtube.com/watch?v=4ZHwu0uut3k"));
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public HashSet<User> getUsers() {
        return users;
    }

    public void setUsers(HashSet<User> users) {
        this.users = users;
    }
}
