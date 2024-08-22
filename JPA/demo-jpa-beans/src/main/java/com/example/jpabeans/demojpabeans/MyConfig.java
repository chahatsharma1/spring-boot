package com.example.jpabeans.demojpabeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
//    @Scope("prototype")
    public HelloWorld getHelloWorldObject() {
        return new HelloWorld("Hello", "Chahat");
    }
}
