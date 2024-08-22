package com.example.jpahibernate.jpa.beans.Repository;

import com.example.jpahibernate.jpa.beans.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  BookRepository extends JpaRepository<Book, Integer> {

//    @Query(value = "select * from Book b where b.author_name = :name", nativeQuery = true)
//    List<Book> findByauthorName(String name);

    @Query(value = "select b from Book b where b.authorName = :name", nativeQuery = false)
    List<Book> findByauthorsName(String name);
}
