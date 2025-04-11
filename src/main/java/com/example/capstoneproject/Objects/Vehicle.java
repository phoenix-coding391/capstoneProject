package com.example.capstoneproject.Objects;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String make;
    private String model;
    private int year;
    private String vin;
    private double value;

    public Vehicle() {}

    public Vehicle(String make, String model, int year, String vin, double value) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Make: " + make +
                ", Model: " + model +
                ", Year: " + year +
                ", VIN: " + vin +
                ", Value: $" + value;
    }
}
