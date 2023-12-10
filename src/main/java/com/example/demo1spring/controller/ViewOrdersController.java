package com.example.demo1spring.controller;

import com.example.demo1spring.model.Order;
import com.example.demo1spring.model.User;
import com.example.demo1spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ViewOrdersController {

    private final OrderService orderService;

    @Autowired
    public ViewOrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/allOrders")
    public String viewAllOrders(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();

        List<Object[]> userOrders = orderService.getAllOrders();

        model.addAttribute("userOrders", userOrders);

        // Log
        System.out.println("Number of user orders fetched: " + userOrders.size());

        // Redirige vers votre vue d'affichage des commandes
        return "myOrders"; // Remplacez "myOrders" par le nom de votre vue JSP ou Thymeleaf
    }
}
