package com.company.customerdataservice.repository;

import com.company.customerdataservice.dto.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repo;

    private Customer customer1;
    private Customer customer2;

    @Before
    public void setUp() {
        // ARRANGE
        repo.deleteAll();

        customer1 = new Customer("Jordan", "James", "123 Front St", "Seattle",
                "Washington", "12345", "Silver");
        customer1 = repo.save(customer1);

        customer2 = new Customer("April", "Yang", "321 Second St", "Portland",
                "Oregon", "67890", "Gold");
        customer2 = repo.save(customer2);
    }

    @Test
    public void shouldReturnCustomersByLevel() {
        // ACT
        List<Customer> result = repo.findByLevel("Silver");

        // ASSERT
        assertEquals(1, result.size());
        assertEquals(customer1, result.get(0));
    }

    @Test
    public void shouldReturnCustomersByState() {
        // ACT
        List<Customer> result = repo.findByState("Oregon");

        // ASSERT
        assertEquals(1, result.size());
        assertEquals(customer2, result.get(0));
    }

}