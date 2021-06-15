package com.company.customerdataservice.dao;

import com.company.customerdataservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoJdbcTemplateImpl implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_CUSTOMER_SQL =
            "INSERT INTO customer (first_name, last_name, street, city, state, zipcode, level) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_CUSTOMER_SQL =
            "SELECT * FROM customer WHERE id = ?";

    private static final String SELECT_ALL_CUSTOMERS_SQL =
            "SELECT * FROM customer";

    private static final String SELECT_ALL_CUSTOMER_LEVEL_SQL =
            "SELECT * FROM customer WHERE level = ?";

    private static final String SELECT_ALL_CUSTOMER_STATE_SQL =
            "SELECT * FROM customer WHERE state = ?";

    private static final String UPDATE_CUSTOMER_SQL =
            "UPDATE customer SET first_name = ?, last_name = ?, street = ?, city = ?, state = ?, zipcode = ?, level = ? WHERE id = ?";

    private static final String DELETE_CUSTOMER_SQL =
            "DELETE FROM customer WHERE id = ?";

    @Autowired
    public CustomerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Customer addCustomer(Customer customer) {
        jdbcTemplate.update(
                INSERT_CUSTOMER_SQL,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getStreet(),
                customer.getCity(),
                customer.getState(),
                customer.getZipcode(),
                customer.getLevel());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        customer.setId(id);
        return customer;
    }

    @Override
    public Customer getCustomer(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CUSTOMER_SQL, this::mapRowToCustomer, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query(SELECT_ALL_CUSTOMERS_SQL, this::mapRowToCustomer);
    }

    @Override
    public List<Customer> getCustomerByLevel(String level) {
        return jdbcTemplate.query(SELECT_ALL_CUSTOMER_LEVEL_SQL, this::mapRowToCustomer, level);
    }

    @Override
    public List<Customer> getCustomerByState(String state) {
        return jdbcTemplate.query(SELECT_ALL_CUSTOMER_STATE_SQL, this::mapRowToCustomer, state);
    }

    @Override
    public void updateCustomer(Customer customer) {
        jdbcTemplate.update(
                UPDATE_CUSTOMER_SQL,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getStreet(),
                customer.getCity(),
                customer.getState(),
                customer.getZipcode(),
                customer.getLevel(),
                customer.getId());
    }

    @Override
    public void deleteCustomer(int id) {
        jdbcTemplate.update(DELETE_CUSTOMER_SQL, id);
    }

    private Customer mapRowToCustomer(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setStreet(rs.getString("street"));
        customer.setCity(rs.getString("city"));
        customer.setState(rs.getString("state"));
        customer.setZipcode(rs.getString("zipcode"));
        customer.setLevel(rs.getString("level"));
        return customer;
    }
}
