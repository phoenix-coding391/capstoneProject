package com.example.capstoneproject.DataAccess;

import com.example.capstoneproject.Quotes.HomeQuote;
import com.example.capstoneproject.Users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface HomeQuoteRepository extends JpaRepository<HomeQuote, Integer> {

    @Transactional
    default HomeQuote saveWithQuote(HomeQuote homeQuote, Customer customer) {
        // Set fields that belong to the Quote superclass
        homeQuote.setQuoteType("Home");  // Just to be safe
        homeQuote.setCustomer(customer); // Set the foreign key relationship
        homeQuote.setExpiryDate(java.time.LocalDate.now().plusDays(30));
        homeQuote.setPaid(false); // Ensure default unpaid

        return save(homeQuote); // This will persist into both Quote and HomeQuote tables
    }
}
