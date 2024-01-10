package com.solvd.persistence.dao;

import com.solvd.model.Customer;

import java.util.List;

public interface CustomerDAO {

    Customer getCustomerByID(int customerID);

    List<Customer> getAllCustomers();

    void addCustomers(Customer customer);

    void updateCustomers(Customer customer);

    void deleteCustomers(int customerID);


}
