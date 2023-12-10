package com.example.demo1spring.repository;

import com.example.demo1spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT MAX(p.id) FROM Product p")
    Integer getMaxProductId();

    @Query("SELECT p.id, p.name, p.price, p.image, u.mail " +
            "FROM Product p JOIN p.user u")
    List<Object[]> getAllProducts();

    @Query("SELECT p.id, p.name, p.price, p.image, u.mail " +
            "FROM Product p JOIN p.user u WHERE u.id = :userId")
    List<Object[]> getAllProductsManage(int userId);
}
