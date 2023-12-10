package com.example.demo1spring.controller;

import com.example.demo1spring.service.ModoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChangeRightsController {

    private final ModoService modoService;

    @Autowired
    public ChangeRightsController(ModoService modoService) {
        this.modoService = modoService;
    }

    @PostMapping("/changeRights")
    @ResponseBody
    public String changeRights(@RequestParam int modoID, @RequestParam String rights) {
        try {
            modoService.changeRights(modoID, rights);
            return "{\"status\":\"success\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"status\":\"error\"}";
        }
    }
}
