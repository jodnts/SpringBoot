package com.example.demo1spring.controller;

import com.example.demo1spring.model.User;
import com.example.demo1spring.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManageProductController {

    private final ProductService productService;

    @Autowired
    public ManageProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/manageProducts")
    public String manageProducts(HttpServletRequest request, Model model) throws ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            String userRole = user.getRole();
            int userId = user.getId();
            System.out.println("userID: " + userId);
            System.out.println("userRole: " + userRole);

            List<Object[]> products;

            if ("admin".equals(userRole)) {
                products = productService.getAllProducts();
            } else if ("modo".equals(userRole)) {
                products = productService.getAllProductsManage(userId);
            } else {
                products = List.of(); // Collections.emptyList() pour les versions antérieures à Java 9
            }

            // Ajoute la liste des produits à l'objet Model pour l'affichage dans la vue
            model.addAttribute("products", products);

            // Log
            System.out.println("Number of products fetched: " + products.size());

            // Redirige vers la vue d'affichage des produits
            return "manageProducts"; // Le nom de ta vue JSP ou Thymeleaf
        }

        // Gérer le cas où l'utilisateur n'est pas connecté ou la session est invalide
        return "redirect:/login"; // Rediriger vers la page de connexion ou une autre page appropriée
    }
}
