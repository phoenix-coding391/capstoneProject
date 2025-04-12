package com.example.capstoneproject.Controllers;

import com.example.capstoneproject.DataAccess.CustomerRepository;
import com.example.capstoneproject.DataAccess.HomeQuoteRepository;
import com.example.capstoneproject.DataAccess.HomeRepository;
import com.example.capstoneproject.Quotes.HomeQuote;
import com.example.capstoneproject.Quotes.QuoteFactory;
import com.example.capstoneproject.Requests.HomeQuoteRequest;
import com.example.capstoneproject.Users.Customer;
import com.example.capstoneproject.Objects.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + HOMEQUOTE)
public class HomeQuoteController {

    @Autowired
    private HomeQuoteRepository homeQuoteRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private HomeRepository homeRepository;

    @GetMapping
    public List<HomeQuote> getAllHomeQuotes() {
        return homeQuoteRepository.findAll();
    }

    @PostMapping
    public HomeQuote createHomeQuote(@RequestBody HomeQuoteRequest request) {
        // Print the HomeQuoteRequest object to validate the input
        System.out.println(request.toString());

        // Validate that customerId is not the default value (0)
        if (request.getCustomerId() == 0) {
            throw new IllegalArgumentException("Customer ID is required.");
        }

        // Validate that homeId is not the default value (0)
        if (request.getHomeId() == 0) {
            throw new IllegalArgumentException("Home ID is required.");
        }

        // Retrieve Customer and Home using the provided IDs
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + request.getCustomerId()));

        Home home = homeRepository.findById(request.getHomeId())
                .orElseThrow(() -> new IllegalArgumentException("Home not found with ID: " + request.getHomeId()));

        // Create the HomeQuote using the QuoteFactory (riskFactor is now calculated in the factory method)
        HomeQuote homeQuote = QuoteFactory.createHomeQuote(customer, home, request.getBaseRate());

        // Save the HomeQuote using the custom saveWithQuote method
        return homeQuoteRepository.saveWithQuote(homeQuote, customer);
    }

    @GetMapping("/{id}")
    public HomeQuote getHomeQuoteById(@PathVariable int id) {
        return homeQuoteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("HomeQuote not found"));
    }

    @PutMapping("/{id}")
    public HomeQuote updateHomeQuote(@PathVariable int id, @RequestBody HomeQuoteRequest request) {
        HomeQuote existingQuote = homeQuoteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("HomeQuote not found with ID: " + id));

        // Optional: Validate updated customer and home
        if (request.getCustomerId() != 0) {
            Customer customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + request.getCustomerId()));
            existingQuote.setCustomer(customer);
        }

        if (request.getHomeId() != 0) {
            Home home = homeRepository.findById(request.getHomeId())
                    .orElseThrow(() -> new IllegalArgumentException("Home not found with ID: " + request.getHomeId()));
            existingQuote.setHome(home);
        }

        // Update quote values (the riskFactor is now calculated inside the QuoteFactory)
        existingQuote.setBaseRate(request.getBaseRate());

        // You don't need to set the riskFactor here as it will be recalculated in the factory
        existingQuote.setQuotePrice(HomeQuote.calculatePremium(request.getBaseRate(), existingQuote.getRiskFactor()));
        existingQuote.setPaid(request.isPaid());
        existingQuote.setExpiryDate(request.getExpiryDate());

        return homeQuoteRepository.save(existingQuote);
    }
}
