package com.example.capstoneproject.Requests;

public class HomeQuoteRequest {
    private int homeId;
    private double baseRate;
    private double riskFactor;
    private int customerId;

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

    @Override
    public String toString() {
        return "HomeQuoteRequest: homeId=" + homeId + ", baseRate=" + baseRate + ", riskFactor=" + riskFactor + ", customerId=" + customerId;
    }
}
