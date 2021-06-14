package com.company.customerdataservice.dao;

import com.company.customerdataservice.model.Customer;

import java.util.List;

public interface CustomerDao {

    Customer addCustomer(Customer customer);

    Customer getCustomer(int id);

    List<Customer> getAllCustomers();

    List<Customer> getCustomerByLevel(String level);

    List<Customer> getCustomerByState(String state);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);
}
