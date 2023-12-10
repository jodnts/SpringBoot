package com.example.demo1spring.repository;

import com.example.demo1spring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Ajoute des méthodes personnalisées si nécessaire
}
