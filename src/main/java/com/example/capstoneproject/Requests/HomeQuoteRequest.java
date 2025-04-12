package com.example.capstoneproject.Requests;

import java.time.LocalDate;

public class HomeQuoteRequest {
    private int homeId;
    private double baseRate;
    private double riskFactor;
    private int customerId;
    private double quotePrice;
    private boolean paid;
    private LocalDate expiryDate;

    public HomeQuoteRequest() {
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    public double getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(double riskFactor) {
        this.riskFactor = riskFactor;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getQuotePrice() {
        return quotePrice;
    }

    public void setQuotePrice(double quotePrice) {
        this.quotePrice = quotePrice;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "HomeQuoteRequest{" +
                "homeId=" + homeId +
                ", baseRate=" + baseRate +
                ", riskFactor=" + riskFactor +
                ", customerId=" + customerId +
                ", quotePrice=" + quotePrice +
                ", paid=" + paid +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
