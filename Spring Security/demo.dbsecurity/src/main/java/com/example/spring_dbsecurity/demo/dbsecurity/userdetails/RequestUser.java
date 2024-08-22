package com.example.spring_dbsecurity.demo.dbsecurity.userdetails;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestUser {

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    private String username;
    private String password;
    String roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return passwordEncoder().encode(this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
