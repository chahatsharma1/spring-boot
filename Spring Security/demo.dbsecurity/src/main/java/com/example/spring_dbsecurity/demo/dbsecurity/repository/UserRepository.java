package com.example.spring_dbsecurity.demo.dbsecurity.repository;

import com.example.spring_dbsecurity.demo.dbsecurity.userdetails.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
