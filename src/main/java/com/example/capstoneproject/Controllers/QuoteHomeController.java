package com.example.capstoneproject.Controllers;

import com.example.capstoneproject.Objects.Home;
import com.example.capstoneproject.Quotes.HomeQuote;
import com.example.capstoneproject.Quotes.HomeQuoteRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + "/quote")
public class QuoteHomeController {

    @PostMapping("/home")
    public HomeQuote calculateHomeQuote(@RequestBody HomeQuoteRequest request) {

        double homeValue = request.getHomeValue();
        String location = request.getLocation();
        int yearBuilt = request.getYearBuilt();
        String heatingType = request.getHeatingType();

        // Create a Home object
        Home home = new Home();
        home.setHomeValue(homeValue);
        home.setLocation(location);
        home.setYearBuilt(yearBuilt);
        home.setHeatingType(heatingType);

        // Quote calculation logic
        double baseRate = 500.0;
        double discountFactor = 1.0;
        double premium = HomeQuote.calculatePremium(baseRate, home, discountFactor);

        // Return a HomeQuote object
        HomeQuote quote = new HomeQuote(0, home, premium);
        quote.setQuoteType("Home");
        quote.setExpiryDate(LocalDate.now().plusMonths(6));
        quote.setPaid(false);

        return quote;
    }
}
