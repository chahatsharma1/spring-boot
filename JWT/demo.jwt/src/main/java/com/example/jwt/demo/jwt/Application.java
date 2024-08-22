package com.example.jwt.demo.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	public PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new MyUserDetails("chahat", passwordEncoder.encode("chahat10"), "ADMIN"));
		userRepository.save(new MyUserDetails("shubhansh", passwordEncoder.encode("shubhansh16"), "ADMIN"));
	}
}
