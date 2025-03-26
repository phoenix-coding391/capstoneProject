package com.example.capstoneproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.capstoneproject.DataAccess.QuoteRepository;
import com.example.capstoneproject.Quotes.Quote;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + QUOTES)
public class QuoteController {
    @Autowired
    private QuoteRepository quoteRepository;

    @GetMapping
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @GetMapping(ID)
    public Quote getQuoteById(@PathVariable int id) {
        return quoteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Quote not found with ID: " + id));
    }

    @PostMapping
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteRepository.save(quote);
    }

    @PutMapping(ID)
    public Quote updateQuote(@PathVariable int id, @RequestBody Quote updatedQuote) {
        Quote existingQuote = quoteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Quote not found with ID: " + id));
        existingQuote.setQuoteType(updatedQuote.getQuoteType());
        existingQuote.setQuotePrice(updatedQuote.getQuotePrice());
        existingQuote.setExpiryDate(updatedQuote.getExpiryDate());
        existingQuote.setPaid(updatedQuote.isPaid());
        return quoteRepository.save(existingQuote);
    }

    @DeleteMapping(ID)
    public void deleteQuote(@PathVariable int id) {
        quoteRepository.deleteById(id);
    }
}
