package com.example.MyApp5;

import java.util.ArrayList;
import java.util.List;

public class MyDB {
    ArrayList<User> userDB = new ArrayList<>();
    public MyDB() {
        userDB.add(new User("TestUser1", 21));
        userDB.add(new User("TestUSer2", 22));
    }

    public void addUser(User user) {
        userDB.add(user);
    }

    public List<User> getAllUsers() {
            return userDB;
    }

    public User findUserByName(String name) {
        User result = null;
        for (User user: userDB) {
            if(user.getName().equals(name)){
                result = user;
                break;
            }
        }
        return result;
    }

    public User updateUserAge(String name, int age) {
        User result = null;
        for (User user: userDB) {
            if(user.getName().equals(name)){
                result = user;
                break;
            }
        }
        result.setAge(age);
        return result;
    }

    public boolean deleteUser(String name) {
        boolean deleted = false;
        for (User user: userDB) {
            if(user.getName().equals(name)){
                userDB.remove(user);
                deleted = true;
                break;
            }
        }
        return deleted;
    }
}
