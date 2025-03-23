package com.controller;

import com.dormmate.model.User;
import com.dormmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RoommateController {

    @Autowired
    private UserRepository userRepository;

    // Show Roommate Match Page
    @GetMapping("/roommate")
    public String showRoommateMatch(Model model) {
        model.addAttribute("matches", null);
        return "roommate";
    }

    // Handle Roommate Match
    @PostMapping("/roommate/match")
    public String matchRoommate(@RequestParam String sleepSchedule, @RequestParam String cleanliness, Model model) {
        List<User> allUsers = userRepository.findAll();
        List<User> matches = allUsers.stream()
            .filter(user -> user.getSleepSchedule().equalsIgnoreCase(sleepSchedule) && 
                           user.getCleanliness().equalsIgnoreCase(cleanliness))
            .collect(Collectors.toList());
        
        model.addAttribute("matches", matches);
        return "roommate";
    }
}
