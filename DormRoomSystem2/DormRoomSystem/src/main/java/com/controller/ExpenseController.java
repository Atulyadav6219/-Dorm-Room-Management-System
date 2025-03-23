package com.controller;

import com.dormmate.model.Expense;
import com.dormmate.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    public static class ExpenseWithSplit {
        private Long id;
        private String description;
        private double amount;
        private String paidBy;
        private String splitAmong;
        private double splitAmount;

        public ExpenseWithSplit(Expense expense) {
            this.id = expense.getId();
            this.description = expense.getDescription();
            this.amount = expense.getAmount();
            this.paidBy = expense.getPaidBy();
            this.splitAmong = expense.getSplitAmong();
            this.splitAmount = calculateSplit(expense);
        }

        private double calculateSplit(Expense expense) {
            String[] users = expense.getSplitAmong().split(",");
            return users.length > 0 ? expense.getAmount() / users.length : 0;
        }

        // Getters
        public Long getId() { return id; }
        public String getDescription() { return description; }
        public double getAmount() { return amount; }
        public String getPaidBy() { return paidBy; }
        public String getSplitAmong() { return splitAmong; }
        public double getSplitAmount() { return splitAmount; }
    }

    @GetMapping("/expenses")
    public String showExpenses(Model model) {
        List<Expense> expenses = expenseRepository.findAll();
        List<ExpenseWithSplit> expensesWithSplit = new ArrayList<>();
        for (Expense expense : expenses) {
            expensesWithSplit.add(new ExpenseWithSplit(expense));
        }
        model.addAttribute("expenses", expensesWithSplit);
        return "expenses";
    }

    @PostMapping("/expenses/add")
    public String addExpense(@RequestParam String description, @RequestParam double amount,
                             @RequestParam String paidBy, @RequestParam String splitAmong, Model model) {
        Expense newExpense = new Expense(description, amount, paidBy, splitAmong);
        expenseRepository.save(newExpense);
        return "redirect:/expenses";
    }
}