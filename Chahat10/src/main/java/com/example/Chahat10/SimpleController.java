package com.example.Chahat10;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class SimpleController {
    UserDatabase database = new UserDatabase();

    @GetMapping("/hi")
    public String sayHi() {
        return "Hello";
    }

//    @RequestMapping(path = "/hi", method = RequestMethod.GET)       // older way
//    public String sayHi() {
//        return "Hello";
//    }

    @GetMapping("/search")                 // query get API
    public String searchWord(@RequestParam String q){
        Data data = new Data();
        return data.searchWord(q);
    }
    @GetMapping("/users")
    public List<User> allUser() {
        return database.getAllUser();
    }

//    @GetMapping("/users/{id}")             // path get API
//    public User aUser(@PathVariable int id) {
//        return database.getAUser(id);
//    }

    @GetMapping("/users/{id}")             // if we want to add things in the header
    public ResponseEntity<User> aUser(@PathVariable int id) {
        User user1 = database.getAUser(id);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("server", Collections.singletonList("codeOfChahat"));
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(user1, headers, status);
    }

    @GetMapping("/users/id")             // query get API
    public User aUserQuery(@RequestParam int id) {
        return database.getAUser(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean createUser(@RequestBody User user){
        return database.addUser(user);
    }

    @DeleteMapping("/users/delete/{id}")
    public boolean deleteUser(@PathVariable int id){
        return database.deleteAUser(id);
    }
}
