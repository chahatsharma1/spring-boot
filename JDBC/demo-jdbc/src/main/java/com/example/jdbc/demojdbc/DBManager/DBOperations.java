package com.example.jdbc.demojdbc.DBManager;

import com.example.jdbc.demojdbc.DAOs.Person;
import com.example.jdbc.demojdbc.Requests.CreateRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    private static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            synchronized (DBOperations.class) {
                if (connection == null) {
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/details", "root", "chahat10");
                }
            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            synchronized (DBOperations.class) {
                if (connection != null) {
                    connection = null;
                }
            }
        }
    }

    public static void createTable(String name) throws SQLException {
        getConnection();

        Statement statement = connection.createStatement();
        boolean isCreated = statement.execute("CREATE TABLE " + name + " (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), age INT, address VARCHAR(50))");
        if (isCreated) {
            System.out.println("table " + name + " is successfully created");
        }
        closeConnection();
    }

    public static void insertPerson(CreateRequest request) throws SQLException {

        getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person VALUES (null, ?, ?, ?)");
        preparedStatement.setString(1, request.getName());
        preparedStatement.setInt(2, request.getAge());
        preparedStatement.setString(3, request.getAddress());

        int rowAffected = preparedStatement.executeUpdate();

        if (rowAffected > 0) {
            System.out.println("Successfully Inserted");
        } else {
            System.out.println("Not Able to Insert");
        }
        closeConnection();
    }

    public static Person getPersonByID(int id) throws SQLException {

        getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Person person = null;

        if (resultSet.next()) {
            int id2 = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String address = resultSet.getString(4);

            person = new Person(id2, name, age, address);
            System.out.println(person);
        }

        closeConnection();
        return person;
    }

    public static void deletePerson(int id) throws SQLException {
        getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id = ?");
        preparedStatement.setInt(1, id);
        int rowAffected = preparedStatement.executeUpdate();
        if (rowAffected > 0){
            System.out.println("Deleted");
        } else {
            System.out.println("Error");
        }
        closeConnection();
    }

    public static void updatePerson(int id, CreateRequest request) throws SQLException {
        getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE person SET name = ?, age = ?, address = ? WHERE id = ?");
        preparedStatement.setString(1, request.getName());
        preparedStatement.setInt(2, request.getAge());
        preparedStatement.setString(3, request.getAddress());
        preparedStatement.setInt(4, id);
        int rowAffected = preparedStatement.executeUpdate();
        if (rowAffected > 0) {
            System.out.println("Updated");
        } else {
            System.out.println("Error");
        }
        closeConnection();

    }

    public static List<Person> getPersons() throws SQLException {
        getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

        List<Person> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String address = resultSet.getString(4);

            Person person = new Person(id, name, age, address);
            System.out.println(person);
            list.add(person);
        }
        closeConnection();
        return list;
    }
}
