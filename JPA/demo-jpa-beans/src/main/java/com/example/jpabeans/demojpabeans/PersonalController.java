package com.example.jpabeans.demojpabeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalController {

    @Autowired
    HelloWorld helloWorld;

    @GetMapping("/function")
    public String func() {
        System.out.println(helloWorld);
        return helloWorld.getMessage() + " " + helloWorld.getData();
    }
}
