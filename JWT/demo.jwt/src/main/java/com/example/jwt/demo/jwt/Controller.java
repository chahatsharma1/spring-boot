package com.example.jwt.demo.jwt;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService a;
    MyUserDetailsService myUserDetailsService(a){
        myUserDetailsService = a;
    }

    @Autowired
    Utils JwtUtils;

    @GetMapping("/user")
    public String user(HttpServletRequest httpServletRequest) {
        return "Hello Users";
    }

    @GetMapping("/home")
    public String home(){
        return "This is Home, Visible to Everyone";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public AuthenticationResponse createToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect Username or Password", e);
        }

        final UserDetails userDetails = myUserDetailsService.userRepository.findByUsername(authenticationRequest.getUsername());

        final String jwt = JwtUtils.generateToken(userDetails);

        return new AuthenticationResponse(jwt);
    }
}
