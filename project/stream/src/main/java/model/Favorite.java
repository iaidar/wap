package model;

import java.util.Objects;

public class Favorite {
    private User user;
    private Video video;

    public Favorite(User user, Video video) {
        this.user = user;
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Favorite)) return false;
        Favorite favorite = (Favorite) o;
        return getUser().equals(favorite.getUser()) &&
                getVideo().equals(favorite.getVideo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getVideo());
    }
}
