package com.company.customerdataservice.controller;

import com.company.customerdataservice.service.ServiceLayer;
import com.company.customerdataservice.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ServiceLayer serviceLayer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerViewModel createCustomer(@RequestBody CustomerViewModel customerViewModel) {
        return serviceLayer.saveCustomer(customerViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerViewModel getCustomer(@PathVariable int id) {
        return serviceLayer.findCustomer(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerViewModel> getAllCustomers() {
        return serviceLayer.findAllCustomers();
    }

    @GetMapping("/level/{level}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerViewModel> getAllCustomersByLevel(@PathVariable String level) {
        return serviceLayer.findAllCustomersByLevel(level);
    }

    @GetMapping("/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerViewModel> getAllCustomersByState(@PathVariable String state) {
        return serviceLayer.findAllCustomersByState(state);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody CustomerViewModel customerViewModel) {
        serviceLayer.updateCustomer(customerViewModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        serviceLayer.removeCustomer(id);
    }
}
