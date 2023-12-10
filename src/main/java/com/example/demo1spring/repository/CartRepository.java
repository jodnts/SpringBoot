package com.example.demo1spring.repository;

import com.example.demo1spring.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Integer> {
    // Ajoute ici les méthodes personnalisées si nécessaire
}
