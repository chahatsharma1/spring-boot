package com.example.jwt.demo.jwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUserDetails, Integer> {

     MyUserDetails findByUsername(String username);
}
