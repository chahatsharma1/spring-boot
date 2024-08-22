package com.example.jpabeans.demojpabeans;

public class HelloWorld {
    private String message;
    private String data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message = " + this.message + ", Data = " + this.data;
    }

    public HelloWorld(String message, String data) {
        this.message = message;
        this.data = data;
    }
}
