package com.oauth2.demo.oauth_demo.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class homeControllers {

    @GetMapping("/")
    public String home(){
        return "Hello From Home";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Hello Secured";
    }

    @RequestMapping("/user")
    public Map<String, Object> getUser(@AuthenticationPrincipal OAuth2User principal){
        Map<String, Object> map = new HashMap<>();
        map.put("Name : ", principal.getAttribute("name"));
        return map;
    }

    @RequestMapping("/user_details")
    public OAuth2User getUserDetails(@AuthenticationPrincipal OAuth2User principal){
        return principal;
    }
}
