package com.example.capstoneproject.Quotes;
public class AutoQuoteRequest {
    private int driverAge;
    private int accidentCount;
    private int vehicleYear;
    private double vehicleValue;

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

    public int getAccidentCount() {
        return accidentCount;
    }

    public void setAccidentCount(int accidentCount) {
        this.accidentCount = accidentCount;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public double getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(double vehicleValue) {
        this.vehicleValue = vehicleValue;
    }
}
