package com.company.customerdataservice.controller;

import com.company.customerdataservice.dto.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerRepository mockRepo;

    ObjectMapper mapper = new ObjectMapper();

    private String inputJson;
    private String outputJson;
//    private List<Customer> levelList = new ArrayList<>();
//    private List<Customer> stateList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        // ARRANGE
        Customer inputCustomer = new Customer("Jordan", "James", "123 Front St", "Seattle",
                "WA", "12345", "Silver");
        inputJson = mapper.writeValueAsString(inputCustomer);

        Customer outputCustomer = new Customer("Jordan", "James", "123 Front St", "Seattle",
                "WA", "12345", "Silver");
        outputCustomer.setId(1);
        outputJson = mapper.writeValueAsString(outputCustomer);

//        levelList.add(outputCustomer);
//        stateList.add(outputCustomer);
//
        when(mockRepo.save(inputCustomer)).thenReturn(outputCustomer);
//        when(mockRepo.findByLevel("Silver")).thenReturn(levelList);
//        when(mockRepo.findByState("Washington")).thenReturn(stateList);
    }

    @Test
    public void shouldReturnNewCustomerOnPostRequest() throws Exception {
        // ACT
        mockMvc.perform(post("/customer")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                // ASSERT
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnAllCustomers() throws Exception {
        // ACT
        mockMvc.perform(get("/customer"))
                // ASSERT
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void shouldReturnCustomerById() throws Exception {
        // ACT
        mockMvc.perform(get("/customer/1"))
                // ASSERT
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        // ACT
        mockMvc.perform(put("/customer")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                // ASSERT
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteCustomerById() throws Exception {
        // ACT
        mockMvc.perform(delete("/customer/1"))
                // ASSERT
                .andDo(print())
                .andExpect(status().isNoContent());
    }

//    @Test
//    public void shouldReturnListOfCustomersByLevel() throws Exception {
//
//    }
}