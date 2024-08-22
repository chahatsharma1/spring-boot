package com.example.spring_dbsecurity.demo.dbsecurity.controllers;

import com.example.spring_dbsecurity.demo.dbsecurity.repository.UserRepository;
import com.example.spring_dbsecurity.demo.dbsecurity.userdetails.RequestUser;
import com.example.spring_dbsecurity.demo.dbsecurity.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controllers {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin")
    public String getAdmin(){
        return "Hello Admin";
    }

    @GetMapping("/student")
    public String getStudent(){
        return "Hello Student";
    }

    @GetMapping("/visitor")
    public String getVisitor(){
        return "Hello Visitor";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insertUser(@RequestBody RequestUser requestUser) {
        User user = new User(requestUser.getUsername(), requestUser.getPassword(), requestUser.getRoles());
        userRepository.save(user);
    }
}
