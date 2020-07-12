package com.example.MyApp5;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * We can define multiple Controllers, no Harm in doing so
 */
@RestController
public class Controller {


    MyDB myDB = new MyDB();

    /**
     *  Will return "Hi there, How you doin"
     *
     */
    @GetMapping("/hi")
    public String sayHello() {
        return "Hi there, How you doin";
    }

    /**
     * Converts USD to INR
     * simple Get Request
     *
     * @param usd
     * @return
     */
    @GetMapping("/convert")
    public String convertUSDtoINR(@RequestParam BigDecimal usd) {
        BigDecimal res = usd.multiply(BigDecimal.valueOf(75));
        return String.valueOf(res);
    }

    /**
     *
     * Returns a new User object
     *
     * @return
     */
    @GetMapping("/user")
    public User getUser() {
        return new User("Ram", 26);
    }

    /**
     *
     * It is a Post Request
     * creates a user and stores it in the myDB
     *
     * @param name
     * @param age
     * @return
     */
    @PostMapping("/cu")
    public User createUser(@RequestParam String name,@RequestParam int age) {
        User user = new User(name, age);
        myDB.addUser(user);
        return user;
    }

    /**
     *
     * Creates a user by Passing JSON object
     *
     * @param user
     * @return
     */
    @PostMapping("/createUserByBody")
    public User createUserByBody(@RequestBody User user) {
        myDB.addUser(user);
        return user;
    }

    @GetMapping("/gau")
    public List<User> getAllUsers() {
        return myDB.getAllUsers();
    }

    @GetMapping("/findUser")
    public User searchUser(@RequestParam String name) {
        return myDB.findUserByName(name);
    }

    /**
     *
     * searches a user using path variable
     * @param name
     * @return
     */
    @GetMapping("/search/user/{name}")
    public User searchUserByPathParam(@PathVariable String name) {
        return myDB.findUserByName(name);
    }

    @PutMapping("/update/user/{name}/{age}")
    public User updateUserAge(@PathVariable String name, @PathVariable int age) {
        return myDB.updateUserAge(name, age);
    }

    /**
     *
     * Delete a user using name as path variable
     * 
     * @param name
     * @return
     */
    @DeleteMapping("/delete/user/{name}")
    public boolean deleteUser(@PathVariable String name) {
        return myDB.deleteUser(name);
    }

}
