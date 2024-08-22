package com.example.jwt.demo.jwt;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String JWT;

    public AuthenticationResponse(String JWT) {
        this.JWT = JWT;
    }

    public String getJwt() {
        return JWT;
    }
}
