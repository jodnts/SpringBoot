package com.example.demo1spring.controller;

import com.example.demo1spring.service.ModoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteModoController {

    private final ModoService modoService;

    @Autowired
    public DeleteModoController(ModoService modoService) {
        this.modoService = modoService;
    }

    @PostMapping("/deleteModo")
    @ResponseBody
    public String deleteModo(@RequestParam int modoID, @RequestParam String mail) {
        try {
            modoService.deleteModo(modoID, mail);
            return "{\"status\":\"success\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"status\":\"error\"}";
        }
    }
}
