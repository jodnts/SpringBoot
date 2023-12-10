package com.example.demo1spring.controller;

import com.example.demo1spring.model.Product;
import com.example.demo1spring.repository.ProductRepository;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String getAllProducts(Model model) throws ServletException {
        List<Product> products = productRepository.findAll();

        // Ajoutez la liste des produits à l'objet Model pour la vue
        model.addAttribute("products", products);

        // Log
        System.out.println("Number of products fetched: " + products.size());

        // Renvoie le nom de la vue JSP (index dans ce cas)
        return "index";
    }
}
