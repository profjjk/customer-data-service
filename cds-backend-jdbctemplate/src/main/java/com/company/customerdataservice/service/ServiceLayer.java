package com.company.customerdataservice.service;

import com.company.customerdataservice.dao.CustomerDao;
import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {
    private final CustomerDao customerDao;

    @Autowired
    public ServiceLayer(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    private CustomerViewModel buildCustomerViewModel(Customer customer) {
        CustomerViewModel customerViewModel = new CustomerViewModel();
        customerViewModel.setId(customer.getId());
        customerViewModel.setFirstName(customer.getFirstName());
        customerViewModel.setLastName(customer.getLastName());
        customerViewModel.setStreet(customer.getStreet());
        customerViewModel.setCity(customer.getCity());
        customerViewModel.setState(customer.getState());
        customerViewModel.setZipcode(customer.getZipcode());
        customerViewModel.setLevel(customer.getLevel());

        return customerViewModel;
    }

    @Transactional
    public CustomerViewModel saveCustomer(CustomerViewModel viewModel) {
        Customer customer = new Customer();
        customer.setFirstName(viewModel.getFirstName());
        customer.setLastName(viewModel.getLastName());
        customer.setStreet(viewModel.getStreet());
        customer.setCity(viewModel.getCity());
        customer.setState(viewModel.getState());
        customer.setZipcode(viewModel.getZipcode());
        customer.setLevel(viewModel.getLevel());

        customer = customerDao.addCustomer(customer);
        viewModel.setId(customer.getId());

        return viewModel;
    }

    public CustomerViewModel findCustomer(int id) {
        Customer customer = customerDao.getCustomer(id);
        return buildCustomerViewModel(customer);
    }

    public List<CustomerViewModel> findAllCustomers() {
        List<Customer> customers = customerDao.getAllCustomers();
        List<CustomerViewModel> allCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            allCustomers.add(buildCustomerViewModel(customer));
        }
        return allCustomers;
    }

    public List<CustomerViewModel> findAllCustomersByLevel(String level) {
        List<Customer> customers = customerDao.getCustomerByLevel(level);
        List<CustomerViewModel> allCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            allCustomers.add(buildCustomerViewModel(customer));
        }
        return allCustomers;
    }

    public List<CustomerViewModel> findAllCustomersByState(String state) {
        List<Customer> customers = customerDao.getCustomerByState(state);
        List<CustomerViewModel> allCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            allCustomers.add(buildCustomerViewModel(customer));
        }
        return allCustomers;
    }

    @Transactional
    public void updateCustomer(CustomerViewModel viewModel) {
        Customer customer = new Customer();
        customer.setId(viewModel.getId());
        customer.setFirstName(viewModel.getFirstName());
        customer.setLastName(viewModel.getLastName());
        customer.setStreet(viewModel.getStreet());
        customer.setCity(viewModel.getCity());
        customer.setState(viewModel.getState());
        customer.setZipcode(viewModel.getZipcode());
        customer.setLevel(viewModel.getLevel());

        customerDao.updateCustomer(customer);
    }

    @Transactional
    public void removeCustomer(int id) {
        customerDao.deleteCustomer(id);
    }
}
