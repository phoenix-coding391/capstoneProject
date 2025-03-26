package com.example.capstoneproject.Quotes;

import jakarta.persistence.*;
import com.example.capstoneproject.Objects.Home;

@Entity
public class HomeQuote extends Quote {
    @OneToOne
    @JoinColumn(name = "home_id")
    private Home home;

    public HomeQuote() {}

    public HomeQuote(int id, Home home, double baseRate, double riskFactor) {
        // Calculate premium with rounding
        super(id, "Home", calculatePremium(baseRate, riskFactor));
        this.home = home;
    }

    // Premium calculation with rounding to the nearest whole number
    private static double calculatePremium(double baseRate, double riskFactor) {
        // Multiply baseRate, riskFactor, and add tax (1.15 factor) then round the result.
        return (double) Math.round(baseRate * riskFactor * 1.15);
    }

    // Getters and setters
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
