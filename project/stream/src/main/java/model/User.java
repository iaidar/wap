package model;

import java.util.HashSet;
import java.util.Objects;

public class User {
    private final long id;
    private String username;
    private String password;
    private HashSet<Favorite> favorites = new HashSet<>();

    public User(long id, String username, String password) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public HashSet<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(HashSet<Favorite> favorites) {
        this.favorites = favorites;
    }

    public int addFavorite(Favorite favorite) {
        for (Favorite fav: favorites) {
            if(fav.equals(fav)) {
             return -1;
            }
        }
        return 1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
