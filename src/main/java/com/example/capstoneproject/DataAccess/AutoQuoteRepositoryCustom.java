package com.example.capstoneproject.DataAccess;

import com.example.capstoneproject.Quotes.AutoQuote;
import com.example.capstoneproject.Users.Customer;

public interface AutoQuoteRepositoryCustom {
    AutoQuote saveWithQuote(AutoQuote autoQuote, Customer customer);
}
