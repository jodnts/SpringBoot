package com.example.demo1spring.service;

import com.example.demo1spring.model.User;
import com.example.demo1spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String mail, String password) {
        return userRepository.findByMailAndPassword(mail, password);
    }

    // Méthode pour enregistrer un utilisateur
    public void registerUser(User user) {
        userRepository.save(user);
    }

    // Méthode pour authentifier un utilisateur
    public boolean authenticateUser(String mail, String password) {
        return userRepository.existsByMailAndPassword(mail, password);
    }
}
