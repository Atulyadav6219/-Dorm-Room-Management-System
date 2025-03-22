package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dormmate.model.*;
import com.dormmate.repository.UserRepository;
import com.service.UserService;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/signup")
//    public String signupPage(Model model) {
//        model.addAttribute("user", new User());
//        return "signup";
//    }
//    @PostMapping("/signup")
//    public String signup(
//        @RequestParam String username,
////        @RequestParam String email,
//        @RequestParam String password
//    ) {
//        User user = new User();
//        user.setUsername(username);
////        user.setEmail(email);
//        user.setPassword(password);
//
//        userService.registerUser(user);
//        return "redirect:/login";
//    }

    @RequestMapping("/")
    public String signUp() {
    	return "/signup";
    }
    @RequestMapping("/login")
    public String signIn() {
    	return "/login";
    }
    
    // Handle Signup
  @PostMapping("/signup")
  public String signup(@RequestParam String username, @RequestParam String password, Model model) {
      if (userRepository.findByUsername(username) != null) {
          model.addAttribute("error", "Username already exists");
          return "login";
      }
      User newUser = new User();
      newUser.setUsername(username);
      newUser.setPassword(password);
//      userRepository.save(newUser);
      userService.registerUser(newUser);
      return "redirect:/dashboard"; // Redirect to dashboard after signup
  }

//Show Dashboard
@RequestMapping("/dashboard")
public String showDashboard() {
    return "dashboard";
}
  
//Handle Login
@PostMapping("/auth")
public String login(@RequestParam String username, @RequestParam String password, Model model) {
  User user = userRepository.findByUsername(username);
  if (user != null && user.getPassword().equals(password)) {
      return "redirect:/dashboard"; // Redirect to dashboard on success
  }
  model.addAttribute("error", "Invalid username or password");
  return "/login";
}

}

