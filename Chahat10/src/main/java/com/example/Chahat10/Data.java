package com.example.Chahat10;

import java.util.HashMap;

public class Data {
    private final HashMap<String, String> store = new HashMap<String, String>();

    public Data(){
        store.put("Chahat", "Good Boy");
        store.put("Adarsh", "Not a Good Boy");
    }
    public String searchWord(String name){
        return store.get(name);
    }
}
