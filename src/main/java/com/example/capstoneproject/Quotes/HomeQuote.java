package com.example.capstoneproject.Quotes;

import jakarta.persistence.*;
import com.example.capstoneproject.Objects.Home;

@Entity
public class HomeQuote extends Quote {

    @OneToOne
    @JoinColumn(name = "home_id")
    private Home home;

    public HomeQuote() {}

    public HomeQuote(int id, Home home, double premium) {
        super(id, "Home", premium);
        this.home = home;
    }

    public static double calculatePremium(double baseRate, Home home, double discountFactor) {
        double valueAdj = 0.0;
        if (home.getHomeValue() > 250000) {
            valueAdj = (home.getHomeValue() - 250000) * 0.002;
        }

        int homeAge = java.time.LocalDate.now().getYear() - home.getYearBuilt();
        double ageFactor = 1.0;
        if (homeAge > 50) {
            ageFactor = 1.5;
        } else if (homeAge > 25) {
            ageFactor = 1.25;
        }

        double heatingFactor;
        String heating = home.getHeatingType().toLowerCase();
        if (heating.equals("oil")) {
            heatingFactor = 2.0;
        } else if (heating.equals("wood")) {
            heatingFactor = 1.25;
        } else {
            heatingFactor = 1.0;
        }

        double locationFactor;
        String location = home.getLocation().toLowerCase();
        if (location.equals("rural")) {
            locationFactor = 1.15;
        } else if (location.equals("urban")) {
            locationFactor = 1.0;
        } else {
            locationFactor = 1.0;
        }

        double premium = (baseRate + valueAdj) * ageFactor * heatingFactor * locationFactor * discountFactor;

        return Math.round(premium * 1.15);
    }

    // Getters and setters
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
