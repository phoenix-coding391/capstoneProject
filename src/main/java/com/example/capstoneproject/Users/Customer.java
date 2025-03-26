package com.example.capstoneproject.Users;

import jakarta.persistence.*;
import com.example.capstoneproject.Policy.Policy;
import com.example.capstoneproject.Quotes.Quote;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends User {
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Policy> policies = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Quote> quotes = new ArrayList<>();

    public Customer() {}

    public Customer(int id, String name, String email) {
        super(id, name, email);
    }

    // Getters and setters
    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public Quote requestHomeQuote(Quote quote) {
        quotes.add(quote);
        return quote;
    }

    public void makePayment(Quote quote) {
        if (!quotes.contains(quote)) {
            throw new IllegalArgumentException("Quote does not exist for this customer.");
        }
        quote.markAsPaid();
        quotes.remove(quote);
        System.out.println("Payment received for Quote: " + quote.getId());
    }

    @Override
    public String toString() {
        return super.toString() + " (Customer)";
    }
}
