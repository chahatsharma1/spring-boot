package com.example.spring.mongo.demo.jpa.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, Integer> {
    public List<Book> findBooksByAuthorName(String authorName);
    public void deleteByAuthorName(String name);
}
