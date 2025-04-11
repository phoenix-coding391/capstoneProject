package com.example.capstoneproject.Quotes;

public class HomeQuoteRequest {
    private double homeValue;
    private String location;
    private int yearBuilt;
    private String heatingType;

    public double getHomeValue() {
        return homeValue;
    }

    public void setHomeValue(double homeValue) {
        this.homeValue = homeValue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(String heatingType) {
        this.heatingType = heatingType;
    }
}
