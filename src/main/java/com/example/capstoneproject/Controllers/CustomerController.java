package com.example.capstoneproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.capstoneproject.DataAccess.CustomerRepository;
import com.example.capstoneproject.Users.Customer;

import java.util.List;

import static com.example.capstoneproject.Controllers.RESTNouns.*;

@RestController
@RequestMapping(VERSION_1 + CUSTOMERS)
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(ID)
    public Customer getCustomerById(@PathVariable int id) {
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + id));
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping(ID)
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + id));
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        return customerRepository.save(existingCustomer);
    }

    @DeleteMapping(ID)
    public void deleteCustomer(@PathVariable int id) {
        customerRepository.deleteById(id);
    }
}
