package com.example.jpahibernate.jpa.beans.Repository;

import com.example.jpahibernate.jpa.beans.Models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
