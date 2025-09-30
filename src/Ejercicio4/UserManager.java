package Ejercicio4;

import java.util.ArrayList;

public class UserManager {
    private static ArrayList<User> users = new ArrayList<>();

    public static boolean isExists(String name){
        for (User user : users){
            if (user.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public static void addUser(User user){
        users.add(user);
    }

    public static User getUser(String name){
        for (User user : users){
            if (user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

}
