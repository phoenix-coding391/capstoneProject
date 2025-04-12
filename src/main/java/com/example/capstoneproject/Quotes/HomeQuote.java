package com.example.capstoneproject.Quotes;

import jakarta.persistence.*;
import com.example.capstoneproject.Objects.Home;

@Entity
public class HomeQuote extends Quote {
    @OneToOne
    @JoinColumn(name = "home_id")
    private Home home;

    private double baseRate;  // New field for base rate
    private double riskFactor;  // New field for risk factor

    public HomeQuote() {}

    public HomeQuote(int id, Home home, double baseRate, double riskFactor) {
        // Calculate premium based on the base rate and risk factor
        super(id, "Home", calculatePremium(baseRate, riskFactor));
        this.home = home;
        this.baseRate = baseRate;
        this.riskFactor = riskFactor;
    }

    // Premium calculation with rounding to the nearest whole number
    public static double calculatePremium(double baseRate, double riskFactor) {
        // Multiply baseRate, riskFactor, and add tax (1.15 factor) then round the result.
        return (double) Math.round(baseRate * riskFactor * 1.15);
    }

    // Getters and setters for baseRate and riskFactor
    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
        // Recalculate the premium when base rate is updated
        setQuotePrice(calculatePremium(baseRate, this.riskFactor));  // Recalculate with new baseRate
    }

    public double getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(double riskFactor) {
        this.riskFactor = riskFactor;
        // Recalculate the premium when risk factor is updated
        setQuotePrice(calculatePremium(this.baseRate, riskFactor));  // Recalculate with new riskFactor
    }

    // Getters and setters for home
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
