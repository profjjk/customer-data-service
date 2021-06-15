package com.company.customerdataservice.controller;

import com.company.customerdataservice.dto.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository repo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(@RequestParam(required=false) String level,
                                          @RequestParam(required=false) String state) {
        if (level != null) {
            return repo.findByLevel(level);
        } else if (state != null) {
            return repo.findByState(state);
        }
        return repo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable int id) {
        return repo.getById(id);
    }

    @GetMapping("/level/{level}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomersByLevel(@PathVariable String level) {
        return repo.findByLevel(level);
    }

    @GetMapping("/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomersByState(@PathVariable String state) {
        return repo.findByLevel(state);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@RequestBody Customer updCustomer) {
        repo.save(updCustomer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }
}
