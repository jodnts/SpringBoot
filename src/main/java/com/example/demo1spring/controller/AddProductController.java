package com.example.demo1spring.controller;

import com.example.demo1spring.model.Product;
import com.example.demo1spring.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddProductController {

    private final ProductService productService;

    @Autowired
    public AddProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addproduct")
    public String addProduct(
            @RequestParam("productName") String productName,
            @RequestParam("productPrice") Double productPrice,
            @RequestParam("productImage") String productImage,
            @RequestParam("userId") int userId,
            RedirectAttributes attributes) {

        try {
            // Créer un objet Product avec les données du formulaire
            Product newProduct = new Product(productName, productPrice, productImage, userId);

            // Ajouter le produit à la base de données via ProductService
            productService.addProduct(newProduct);

            // Rediriger vers une page de confirmation ou une autre page appropriée avec un attribut de succès
            attributes.addFlashAttribute("success", true);
            return "redirect:/products";
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs de manière appropriée avec un attribut d'erreur
            attributes.addFlashAttribute("error", true);
            return "redirect:/products";
        }
    }
}
