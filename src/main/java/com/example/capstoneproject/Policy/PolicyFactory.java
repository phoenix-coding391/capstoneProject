package com.example.capstoneproject.Policy;

import com.example.capstoneproject.Users.Customer;
import com.example.capstoneproject.Quotes.Quote;

public class PolicyFactory {
    public static Policy createPolicy(Customer customer, Quote quote) {
        String policyType = quote.getQuoteType();

        // Validate home policy restriction
        if (policyType.equals("Home")) {
            long activeHomePolicies = customer.getPolicies().stream()
                    .filter(policy -> policy.getPolicyType().equals("Home") && policy.getStatus().equals("Active"))
                    .count();
            if (activeHomePolicies >= 1) {
                throw new IllegalStateException("Customer already has an active home policy.");
            }
        }

        // Validate auto policy restriction
        if (policyType.equals("Auto")) {
            long activeAutoPolicies = customer.getPolicies().stream()
                    .filter(policy -> policy.getPolicyType().equals("Auto") && policy.getStatus().equals("Active"))
                    .count();
            if (activeAutoPolicies >= 2) {
                throw new IllegalStateException("Customer already has 2 active auto policies.");
            }
        }

        // Base premium, tax, and total premium
        double basePremium = quote.getQuotePrice();
        double taxRate = 0.15; // 15% HST

        // Create policy and link to customer
        Policy policy = new Policy("P-" + (customer.getPolicies().size() + 1), quote.getId(), policyType, basePremium, taxRate);
        policy.setCustomer(customer);
        customer.getPolicies().add(policy);
        return policy;
    }
}
