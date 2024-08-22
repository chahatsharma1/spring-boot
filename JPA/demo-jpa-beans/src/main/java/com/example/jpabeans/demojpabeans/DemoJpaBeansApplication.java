package com.example.jpabeans.demojpabeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoJpaBeansApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaBeansApplication.class, args);

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(MyConfig.class);
//		context.refresh();
//
//		HelloWorld obj = context.getBean(HelloWorld.class);
//		HelloWorld obj2 = context.getBean(HelloWorld.class);
//
//		obj.setMessage("Hello ");
//		obj.setData("Chahat");
//
//		System.out.println(obj);
//		System.out.println(obj2);
	}
}
