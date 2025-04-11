package com.example.capstoneproject.DataAccess;

import com.example.capstoneproject.Quotes.HomeQuote;
import org.springframework.data.jpa.repository.JpaRepository;

// Extend the custom interface here
public interface HomeQuoteRepository extends JpaRepository<HomeQuote, Integer>, HomeQuoteRepositoryCustom {
    // JpaRepository gives you save(), findById(), etc.
    // HomeQuoteRepositoryCustom gives you saveWithQuote()
}
