package com.example.capstoneproject.DataAccess;

import com.example.capstoneproject.Quotes.HomeQuote;
import com.example.capstoneproject.Users.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HomeQuoteRepositoryCustomImpl implements HomeQuoteRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public HomeQuote saveWithQuote(HomeQuote homeQuote, Customer customer) {
        homeQuote.setId(0); // <- Force new ID
        homeQuote.setQuoteType("Home");
        homeQuote.setCustomer(customer);
        homeQuote.setExpiryDate(java.time.LocalDate.now().plusDays(30));
        homeQuote.setPaid(false);

        entityManager.persist(homeQuote);

        return homeQuote;
    }

}
