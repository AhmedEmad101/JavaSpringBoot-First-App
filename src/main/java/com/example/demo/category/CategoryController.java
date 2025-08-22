package com.example.demo.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping("/api")
public class CategoryController {
    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("message", "Welcome!");
        return "index"; // Renders home.html from src/main/resources/templates/
    }
}
