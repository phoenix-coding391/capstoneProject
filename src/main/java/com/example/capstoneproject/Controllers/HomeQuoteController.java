package com.example.capstoneproject.Controllers;

import com.example.capstoneproject.DataAccess.CustomerRepository;
import com.example.capstoneproject.DataAccess.HomeQuoteRepository;
import com.example.capstoneproject.Quotes.HomeQuote;
import com.example.capstoneproject.Users.Customer;
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

    @GetMapping
    public List<HomeQuote> getAllHomeQuotes() {
        return homeQuoteRepository.findAll();
    }

    @PostMapping
    public HomeQuote createHomeQuote(@RequestBody HomeQuote homeQuote) {
        // Extract customer ID (sent in JSON), fetch Customer, and associate
        Integer customerId = homeQuote.getCustomerId();
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID is required.");
        }

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + customerId));

        // Save with custom logic
        return homeQuoteRepository.saveWithQuote(homeQuote, customer);
    }

    @GetMapping("/{id}")
    public HomeQuote getHomeQuoteById(@PathVariable int id) {
        return homeQuoteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("HomeQuote not found"));
    }
}
