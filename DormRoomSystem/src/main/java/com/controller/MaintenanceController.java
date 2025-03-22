package com.controller;


import com.dormmate.model.Maintenance;
import com.dormmate.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MaintenanceController {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    // Show Maintenance Page
    @GetMapping("/maintenance")
    public String showMaintenance(Model model) {
        model.addAttribute("requests", maintenanceRepository.findAll());
        return "maintenance";
    }

    // Add Maintenance Request
    @PostMapping("/maintenance/add")
    public String addMaintenance(@RequestParam String description, @RequestParam String reportedBy, Model model) {
        Maintenance newRequest = new Maintenance(description, reportedBy);
        maintenanceRepository.save(newRequest);
        return "redirect:/maintenance";
    }
}
