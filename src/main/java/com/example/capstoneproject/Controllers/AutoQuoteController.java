// AutoQuoteController
package com.example.capstoneproject.Controllers;

import com.example.capstoneproject.DataAccess.AutoQuoteRepository;
import com.example.capstoneproject.DataAccess.QuoteRepository;
import com.example.capstoneproject.Quotes.AutoQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + AUTOQUOTE)
public class AutoQuoteController {

    @Autowired
    private AutoQuoteRepository autoQuoteRepository;

    private QuoteRepository quoteRepository;

    @GetMapping
    public List<AutoQuote> getAllAutoQuotes() {
        return autoQuoteRepository.findAll();
    }

    @PostMapping
    public AutoQuote createAutoQuote(@RequestBody AutoQuote autoQuote) {
        return autoQuoteRepository.save(autoQuote); // Custom logic can be added if needed
    }

    @GetMapping("/{id}")
    public AutoQuote getAutoQuoteById(@PathVariable int id) {
        return autoQuoteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("AutoQuote not found"));
    }
}
