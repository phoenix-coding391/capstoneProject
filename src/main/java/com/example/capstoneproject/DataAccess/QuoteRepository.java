package com.example.capstoneproject.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.capstoneproject.Quotes.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
}
