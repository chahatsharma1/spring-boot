package com.example.jdbc.demojdbc.DAOs;

public class Person {

    private int id;
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public Person(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + ", age=" + age + '}';
    }
}
