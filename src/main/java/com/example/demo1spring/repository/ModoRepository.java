package com.example.demo1spring.repository;

import com.example.demo1spring.model.Modo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModoRepository extends JpaRepository<Modo, Integer> {

    // Ajoute des méthodes personnalisées si nécessaire en fonction des opérations spécifiques à la base de données
}
