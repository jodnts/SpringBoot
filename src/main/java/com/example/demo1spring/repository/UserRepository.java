package com.example.demo1spring.repository;

import com.example.demo1spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByMailAndPassword(String mail, String password);
    boolean existsByMailAndPassword(String mail, String password);

}

