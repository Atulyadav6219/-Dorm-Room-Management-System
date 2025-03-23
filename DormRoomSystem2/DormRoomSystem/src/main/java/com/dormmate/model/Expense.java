package com.dormmate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double amount;
    private String paidBy;      // Username of who paid
    private String splitAmong;  // Comma-separated usernames (e.g., "bhai1,bhai2")

    public Expense() {}
    public Expense(String description, double amount, String paidBy, String splitAmong) {
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitAmong = splitAmong;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getPaidBy() { return paidBy; }
    public void setPaidBy(String paidBy) { this.paidBy = paidBy; }
    public String getSplitAmong() { return splitAmong; }
    public void setSplitAmong(String splitAmong) { this.splitAmong = splitAmong; }
}
