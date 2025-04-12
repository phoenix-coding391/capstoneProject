package com.example.capstoneproject.Controllers;

import com.example.capstoneproject.DataAccess.CustomerRepository;
import com.example.capstoneproject.DataAccess.PolicyRepository;
import com.example.capstoneproject.DataAccess.QuoteRepository;
import com.example.capstoneproject.Policy.Policy;
import com.example.capstoneproject.Policy.PolicyFactory;
import com.example.capstoneproject.Requests.PolicyRequest;
import com.example.capstoneproject.Quotes.Quote;
import com.example.capstoneproject.Users.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + POLICIES)
public class PolicyController {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private QuoteRepository quoteRepository;

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @GetMapping(ID)
    public Policy getPolicyById(@PathVariable int id) {
        return policyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Policy not found with ID: " + id));
    }

    @PostMapping
    public Policy createPolicy(@RequestBody PolicyRequest request) {
        // Fetch the customer based on the ID
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + request.getCustomerId()));

        // Fetch the quote based on the ID
        Quote quote = quoteRepository.findById(request.getQuoteId())
                .orElseThrow(() -> new IllegalArgumentException("Quote not found with ID: " + request.getQuoteId()));

        // Use PolicyFactory to create the policy, policy number will be generated automatically
        Policy policy = PolicyFactory.createPolicy(customer, quote);

        // Save the newly created policy to the repository
        return policyRepository.save(policy);
    }

    @PutMapping(ID)
    public Policy updatePolicy(@PathVariable int id, @RequestBody Policy updatedPolicy) {
        // Fetch the existing policy to update
        Policy existingPolicy = policyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Policy not found with ID: " + id));

        // Update necessary fields (you can expand this as needed)
        existingPolicy.setStatus(updatedPolicy.getStatus());
        existingPolicy.setPaid(updatedPolicy.isPaid());

        // Recalculate totalPremium if basePremium or taxRate were updated
        existingPolicy.setBasePremium(updatedPolicy.getBasePremium());
        existingPolicy.setTaxRate(updatedPolicy.getTaxRate());

        // Save the updated policy
        return policyRepository.save(existingPolicy);
    }

    @DeleteMapping(ID)
    public void deletePolicy(@PathVariable int id) {
        // Delete the policy by ID
        policyRepository.deleteById(id);
    }
}
