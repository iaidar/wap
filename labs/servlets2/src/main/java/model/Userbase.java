package model;


import java.util.HashMap;

public class Userbase {
    private static HashMap<String, User> db = new HashMap<>();

    public static boolean userExists(User user) {
        if (user == null) return false;
        setDB();
        return db.containsValue(user);

    }

    private static void setDB(){
        User testUser1 = new User("user","123");
        db.put("1",testUser1);
    }
}
