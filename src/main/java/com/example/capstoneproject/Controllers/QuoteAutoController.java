package com.example.capstoneproject.Controllers;

import com.example.capstoneproject.Objects.Vehicle;
import com.example.capstoneproject.Quotes.AutoQuote;
import com.example.capstoneproject.Quotes.AutoQuoteRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + "/quote")
public class QuoteAutoController {

    @PostMapping("/auto")
    public AutoQuote calculateAutoQuote(@RequestBody AutoQuoteRequest request) {

        int driverAge = request.getDriverAge();
        int accidentCount = request.getAccidentCount();
        int vehicleYear = request.getVehicleYear();
        double vehicleValue = request.getVehicleValue();

        // Create vehicle object with values sent from the frontend
        Vehicle vehicle = new Vehicle();
        vehicle.setYear(vehicleYear);
        vehicle.setValue(vehicleValue);

        // Calculate premium using Jasons AutoQuote
        double baseRate = 750;
        double discountFactor = 1;
        double premium = AutoQuote.calculatePremium(baseRate, driverAge, accidentCount, vehicle, discountFactor);

        AutoQuote quote = new AutoQuote(0, vehicle, driverAge, accidentCount, premium);
        return quote;
    }
}
