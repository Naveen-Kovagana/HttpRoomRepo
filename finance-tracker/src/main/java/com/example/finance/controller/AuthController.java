package com.example.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.finance.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(@RequestParam("username") String username,
                               @RequestParam("password") String password, Model model) {
        // Add your authentication logic here
        return "redirect:/dashboard"; // After successful login, redirect to dashboard
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("profession") String profession,
                               @RequestParam("gender") String gender,
                               @RequestParam("monthlySalary") String monthlySalary,
                               Model model) {
        // Add registration logic here
        userService.registerNewUser(email, password, profession, gender, monthlySalary);
        return "redirect:/login"; // After successful sign-up, redirect to login
    }
}
