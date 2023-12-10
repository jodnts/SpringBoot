package com.example.demo1spring.service;

import com.example.demo1spring.model.Product;
import com.example.demo1spring.model.User;
import com.example.demo1spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void addProduct(Product product) throws ServletException {
        try {
            Integer maxId = productRepository.getMaxProductId();
            int newId = (maxId != null) ? maxId + 1 : 1;

            product.setId(newId);
            productRepository.save(product);
        } catch (Exception e) {
            throw new ServletException("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
    }

    public List<Object[]> getAllProducts() throws ServletException {
        try {
            return productRepository.getAllProducts();
        } catch (Exception e) {
            throw new ServletException("Erreur lors de la récupération des produits : " + e.getMessage());
        }
    }

    public List<Object[]> getAllProductsManage(int userId) throws ServletException {
        try {
            return productRepository.getAllProductsManage(userId);
        } catch (Exception e) {
            throw new ServletException("Erreur lors de la récupération des produits : " + e.getMessage());
        }
    }

    @Transactional
    public void deleteProduct(int productId) throws ServletException {
        try {
            productRepository.deleteById(productId);
        } catch (Exception e) {
            throw new ServletException("Erreur lors de la suppression du produit : " + e.getMessage());
        }
    }

    public Product getProductById(int productId) throws ServletException {
        try {
            return productRepository.findById(productId).orElse(null);
        } catch (Exception e) {
            throw new ServletException("Erreur lors de la récupération du produit : " + e.getMessage());
        }
    }
}
