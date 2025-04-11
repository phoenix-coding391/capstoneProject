package com.example.capstoneproject.DataAccess;

import com.example.capstoneproject.Quotes.HomeQuote;
import com.example.capstoneproject.Users.Customer;

public interface HomeQuoteRepositoryCustom {
    HomeQuote saveWithQuote(HomeQuote homeQuote, Customer customer);
}
