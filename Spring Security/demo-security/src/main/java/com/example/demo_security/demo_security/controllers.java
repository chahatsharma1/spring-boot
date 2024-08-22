package com.example.demo_security.demo_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllers {

    @GetMapping("/student")
    public String getStudent() {
        return "Hello Student";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Hello Admin";
    }

    // this API does not require authentication and authorization
    @GetMapping("/visitor")
    public String getVisitor(){
        return "Hello Visitor";
    }
}
