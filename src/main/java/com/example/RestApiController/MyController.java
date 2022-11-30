package com.example.RestApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController  // controller use kr rhe hai isliye iska use kr rhe hai kyuki hme btana pdega ki hm ae use kr rhe hai
public class MyController {

     /// IOC Concept-----------------
    @Autowired
           // otherController obj = new otherController(); Ae banne ki jrurt nhi hai kyuki hmne Autowired ke diye hai so
            otherController obj; // Bn gya hmara object.. using Spring boot IOC


    // hm database use nhi kr rhe hai isliye ae use kr rhe, hai hm khud ka db bnane ki kosis kr rhe hai
    // Using as a db
    Map<Integer, User> users = new HashMap<>();
     // how to access your API's , Ans-->> Using EndPoint
    // GET METHOD-------------------
    @GetMapping("/get_users")// this is my First Api's , this is the the Spring Syntax
    public List<User> getUsers() {
        List<User> listOfUsers = new ArrayList<>();
        for(User user: users.values()){
            listOfUsers.add(user);
        }
        return listOfUsers;
    }

    // POST METHOD
    // this method use for creating the users

    @PostMapping("/add_user")
    public void addUser(@RequestParam("id")int id,
                        @RequestParam("name") String name,
                        @RequestParam("age") int age,
                        @RequestParam("country") String country) {
        // Request param is the parameter we use the to find the known name or palce called as the request parameter
        // for example-->> search sachin then get the search?q=sachin, this is the request param
        User user = new User(id,name,country,age);
        users.put(id,user);
       // System.out.println(users);
    }

    @PostMapping("/add_user_body") // this is the endi point of API's
    public void adduserBody(@RequestBody(required = true)User u){
            users.put(u.getId(), u);
    }

    // Get the user which have particular ID
    // this is also call path parameter
    @GetMapping("/get_user/{id}")
    public User getUser(@PathVariable("id")int id){
        return users.get(id);
    }

    //Delete User
    @DeleteMapping(".delete_user/{id}")
    public void deleteUser(@PathVariable("id")int idx){
        users.remove(idx);
    }

    //update user
    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable("id")int idx, @RequestBody() User user){
        users.put(idx,user);
    }
}
