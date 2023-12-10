package com.example.demo1spring.service;

import com.example.demo1spring.model.Modo;
import com.example.demo1spring.repository.ModoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModoService {

    private final ModoRepository modoRepository;

    @Autowired
    public ModoService(ModoRepository modoRepository) {
        this.modoRepository = modoRepository;
    }

    public Modo getModoByUserId(int userId) {
        // Implémente la logique pour récupérer un modérateur par ID d'utilisateur si nécessaire
        return null;
    }

    public List<Object[]> getAllModos() {
        // Implémente la logique pour récupérer tous les modérateurs si nécessaire
        return null;
    }

    public void changeRights(int modoId, String rights) {
        // Implémente la logique pour modifier les droits d'un modérateur si nécessaire
    }

    public void deleteModo(int modoId, String mail) {
        // Implémente la logique pour supprimer un modérateur si nécessaire
    }

    public void addModo(String mail) {
        // Implémente la logique pour ajouter un modérateur si nécessaire
    }
}
