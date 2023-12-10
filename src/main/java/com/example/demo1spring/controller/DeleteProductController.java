package com.example.demo1spring.controller;

import com.example.demo1spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteProductController {

    private final ProductService productService;

    @Autowired
    public DeleteProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/deleteproduct")
    @ResponseBody
    public String deleteProduct(@RequestParam int productId) {
        try {
            productService.deleteProduct(productId);
            return "{\"status\":\"success\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"status\":\"error\"}";
        }
    }
}
