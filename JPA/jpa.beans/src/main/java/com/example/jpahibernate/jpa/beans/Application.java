package com.example.jpahibernate.jpa.beans;

import com.example.jpahibernate.jpa.beans.Models.Book;
import com.example.jpahibernate.jpa.beans.Repository.BookCategoryRepository;
import com.example.jpahibernate.jpa.beans.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCategoryRepository bookCategoryRepository;

	@Override
	public void run(String... args) throws Exception {
//		Set<Book> set = new HashSet<>();
//		Book book1 = new Book("Kotlin", "Chahat", 1000);
		Book book2 = new Book("Java", "Shubhansh", 1000, 2);
//		set.add(book1);
//		set.add(book2);
		bookRepository.save(book2);
//		bookRepository.save(book1);

//		bookCategoryRepository.save(new BookCategory(" Non Programming Language"));
//		bookCategoryRepository.save(new BookCategory("Programming Language", set));

	}
}
