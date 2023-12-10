package com.example.demo1spring.controller;

import com.example.demo1spring.model.Modo;
import com.example.demo1spring.service.ModoService;
import com.example.demo1spring.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManageModoController {

    private final ModoService modoService;

    @Autowired
    public ManageModoController(ModoService modoService) {
        this.modoService = modoService;
    }

    @GetMapping("/manageModos")
    public String manageModos(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null && "admin".equals(user.getRole())) {
            List<Object[]> modos = modoService.getAllModos();
            model.addAttribute("modos", modos);
            return "manageModo"; // Le nom de la vue à afficher (manageModo.jsp par exemple)
        } else {
            // Rediriger vers une page d'erreur ou autre traitement approprié
            return "redirect:/errorPage";
        }
    }
}
