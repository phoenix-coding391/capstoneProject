package com.example.capstoneproject.Quotes;

import jakarta.persistence.*;
import com.example.capstoneproject.Users.Customer;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String quoteType;
    private double quotePrice;
    private LocalDate expiryDate;
    private boolean isPaid;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Default constructor (for deserialization)
    public Quote() {}

    // Existing overloaded constructor
    public Quote(int id, String quoteType, double quotePrice) {
        this.id = id;
        this.quoteType = quoteType;
        this.quotePrice = quotePrice;
        this.expiryDate = LocalDate.now().plusDays(30);
        this.isPaid = false;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }

    public double getQuotePrice() {
        return quotePrice;
    }

    public void setQuotePrice(double quotePrice) {
        this.quotePrice = quotePrice;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public void markAsPaid() {
        if (isExpired()) {
            throw new IllegalStateException("Cannot pay for an expired quote.");
        }
        this.isPaid = true;
    }

    @Override
    public String toString() {
        return "Quote Type: " + quoteType + ", ID: " + id + ", Price: $" + quotePrice +
                ", Expiry Date: " + expiryDate + ", Paid: " + isPaid;
    }
}
