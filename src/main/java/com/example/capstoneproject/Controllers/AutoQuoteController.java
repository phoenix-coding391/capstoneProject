package com.example.capstoneproject.Controllers;

import com.example.capstoneproject.DataAccess.AutoQuoteRepository;
import com.example.capstoneproject.DataAccess.CustomerRepository;
import com.example.capstoneproject.DataAccess.VehicleRepository;
import com.example.capstoneproject.Quotes.AutoQuote;
import com.example.capstoneproject.Quotes.QuoteFactory;
import com.example.capstoneproject.Requests.AutoQuoteRequest;
import com.example.capstoneproject.Users.Customer;
import com.example.capstoneproject.Objects.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + AUTOQUOTE)
public class AutoQuoteController {

    @Autowired
    private AutoQuoteRepository autoQuoteRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<AutoQuote> getAllAutoQuotes() {
        return autoQuoteRepository.findAll();
    }

    @PostMapping
    public AutoQuote createAutoQuote(@RequestBody AutoQuoteRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));

        AutoQuote autoQuote = QuoteFactory.createAutoQuote(
                customer,
                vehicle,
                request.getDriverAge(),
                request.getAccidentCount(),
                request.getBaseRate()
        );

        return autoQuoteRepository.saveWithQuote(autoQuote, customer);
    }

    @GetMapping("/{id}")
    public AutoQuote getAutoQuoteById(@PathVariable int id) {
        return autoQuoteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("AutoQuote not found"));
    }
}
