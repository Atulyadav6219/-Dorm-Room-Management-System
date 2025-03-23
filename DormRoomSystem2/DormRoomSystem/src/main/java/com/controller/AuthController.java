package com.controller;

import com.dormmate.model.User;
import com.dormmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Show Login Page (GET)
    @GetMapping("/")
    public String showLogin(Model model) {
        model.addAttribute("error", null);
        return "login";
    }

    // Handle Login (POST)
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) { // Plain text comparison for now
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    // Show Signup Page (GET)
    @GetMapping("/signup")
    public String showSignup(Model model) {
        model.addAttribute("error", null);
        return "signup";
    }

    // Handle Signup (POST)
    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password,
                         @RequestParam String sleepSchedule, @RequestParam String cleanliness, Model model) {
        if (userRepository.findByUsername(username) != null) {
            model.addAttribute("error", "Username already exists");
            return "signup";
        }
        User newUser = new User(username, password, sleepSchedule, cleanliness); // Plain text password for simplicity
        userRepository.save(newUser);
        return "redirect:/"; // Back to login
    }

    // Show Dashboard (GET)
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }
}
