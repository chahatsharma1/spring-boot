package com.example.jdbc.demojdbc.controllers;

import com.example.jdbc.demojdbc.DAOs.Person;
import com.example.jdbc.demojdbc.DBManager.DBOperations;
import com.example.jdbc.demojdbc.Requests.CreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
public class PersonalControllers {

    @GetMapping("/hi")
    public String hello(){
        return "Hello";
    }

    @GetMapping( "/getPerson")
    public List<Person> getPersons() throws SQLException {
        return DBOperations.getPersons();
    }

    @GetMapping("/getPerson/{id}")
    public Person getPersonByID(@PathVariable int id) throws SQLException {
        return DBOperations.getPersonByID(id);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) throws SQLException {
        DBOperations.deletePerson(id);
    }

    @Operation(summary = "This will create a new User")     // for telling what is does for the reference to docs
    @RequestMapping(value = "/insertPerson", method = RequestMethod.POST)
    public void insertPerson(@RequestBody CreateRequest request) throws SQLException {
        DBOperations.insertPerson(request);
    }

    @RequestMapping(value = "/createTable", method = RequestMethod.POST)
    public void createTable(@RequestParam(value = "name") String name) throws SQLException {
        DBOperations.createTable(name);
    }

    @PutMapping(value = "/update/{id}")
    public void updatePerson(@PathVariable int id, @RequestBody CreateRequest request) throws SQLException {
        DBOperations.updatePerson(id, request);
    }
}
