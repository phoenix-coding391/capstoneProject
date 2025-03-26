package com.example.capstoneproject.Quotes;

import jakarta.persistence.*;
import com.example.capstoneproject.Objects.Vehicle;
import java.time.LocalDate;

@Entity
public class AutoQuote extends Quote {
    private int driverAge;
    private int accidentCount;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public AutoQuote() {}

    // Constructor now receives the pre-calculated premium
    public AutoQuote(int id, Vehicle vehicle, int driverAge, int accidentCount, double premium) {
        super(id, "Auto", premium);
        this.vehicle = vehicle;
        this.driverAge = driverAge;
        this.accidentCount = accidentCount;
    }

    // Existing internal risk factor calculation (without discount)
    private static double calculatePremium(double baseRate, int driverAge, int accidentCount, Vehicle vehicle) {
        double driverFactor = driverAge < 25 ? 2.0 : 1.0;
        double accidentFactor = accidentCount > 2 ? 2.5 : (accidentCount == 1 ? 1.25 : 1.0);
        double vehicleFactor = vehicle.getYear() < LocalDate.now().getYear() - 10 ? 2.0 :
                (vehicle.getYear() < LocalDate.now().getYear() - 5 ? 1.5 : 1.0);
        // Multiply by the tax factor of 1.15 and round the result
        return (double) Math.round(baseRate * driverFactor * accidentFactor * vehicleFactor * 1.15);
    }

    // New overloaded method that takes discountFactor into account
    public static double calculatePremium(double baseRate, int driverAge, int accidentCount, Vehicle vehicle, double discountFactor) {
        double basePremium = calculatePremium(baseRate, driverAge, accidentCount, vehicle);
        return (double) Math.round(basePremium * discountFactor);
    }

    // Getters and setters
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
