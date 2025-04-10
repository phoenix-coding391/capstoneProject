package com.example.capstoneproject.Objects;

import jakarta.persistence.*;

@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private int yearBuilt;
    private double homeValue;

    private String typeOfDwelling;
    private String heatingType;
    private String location;
    private double liabilityLimit;

    public Home() {}

    public Home(String address, int yearBuilt, double homeValue, String typeOfDwelling, String heatingType, String location, double liabilityLimit) {
        this.address = address;
        this.yearBuilt = yearBuilt;
        this.homeValue = homeValue;
        this.typeOfDwelling = typeOfDwelling;
        this.heatingType = heatingType;
        this.location = location;
        this.liabilityLimit = liabilityLimit;
    }

    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public double getHomeValue() {
        return homeValue;
    }

    public void setHomeValue(double homeValue) {
        this.homeValue = homeValue;
    }

    public String getTypeOfDwelling() {
        return typeOfDwelling;
    }

    public void setTypeOfDwelling(String typeOfDwelling) {
        this.typeOfDwelling = typeOfDwelling;
    }

    public String getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(String heatingType) {
        this.heatingType = heatingType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLiabilityLimit() {
        return liabilityLimit;
    }

    public void setLiabilityLimit(double liabilityLimit) {
        this.liabilityLimit = liabilityLimit;
    }

    @Override
    public String toString() {
        return "Address: " + address + ", Year Built: " + yearBuilt + ", Home Value: $" + homeValue +
                ", Dwelling Type: " + typeOfDwelling + ", Heating: " + heatingType +
                ", Location: " + location + ", Liability Limit: $" + liabilityLimit;
    }
}
