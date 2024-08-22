package com.example.Chahat10;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private List<User> userTable = new ArrayList<>();

    public UserDatabase(){
        userTable.add(new User(1, "Chahat", 22));
        userTable.add(new User(2, "Adarsh", 20));
        userTable.add(new User(3, "Shubhansh", 21));
        userTable.add(new User(4, "Akhil", 24));
        userTable.add(new User(5, "Ayush", 18));
    }

    public List<User> getAllUser(){
        return userTable;
    }

    public User getAUser(int id){
         for (User user : userTable){
             if (user.getId() == id){
                 return user;
             }
         }
        return null;
    }

    public boolean addUser(User user){
         return userTable.add(user);
    }

    public boolean deleteAUser(int id) {
        for (User user : userTable) {
            if (user.getId() == id) {
                userTable.remove(user);
                return true;
            }
        }
        return false;
    }
}
