package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dormmate.model.Task;
import com.dormmate.model.User;
import com.dormmate.repository.TaskRepository;
import com.dormmate.repository.UserRepository;


@Controller
public class HomeController {

	@Autowired
    private UserRepository userRepository;
	@Autowired
	private TaskRepository taskRepository;
	

@RequestMapping("/tasks")
public String tasks() {
	return "tasks";
}
	
@PostMapping("/add")
public String addTask(@RequestParam String description, @RequestParam String assignedTo, Model model) {
    Task newTask = new Task(description, assignedTo);
    taskRepository.save(newTask);
    return "redirect:/tasks"; // Redirect back to tasks page
}

@GetMapping("/tasks")
public String showTasks(Model model) {
    model.addAttribute("tasks", taskRepository.findAll());
    model.addAttribute("error", null);
    return "tasks";
}

@RequestMapping("/maintenance")
public String maintenance() {
	return "maintenance";
}

//@RequestMapping("/logout")
//public String logout() {
//	return "login";
//}


}
