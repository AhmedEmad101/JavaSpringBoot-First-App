package com.example.demo.student;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }
        return "login";  // return login.html template
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        // Simple hardcoded authentication example (replace with real auth logic)
        if ("admin".equals(username) && "password123".equals(password)) {
            // success: redirect to home page (or dashboard)
            return "redirect:/api/home";
        } else {
            // failure: redirect back to login with error flag
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("message", "Welcome, you are logged in!");
        return "home"; // You'll need a simple home.html page
    }
}
