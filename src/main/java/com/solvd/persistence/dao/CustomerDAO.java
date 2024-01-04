package com.solvd.persistence.dao;

import com.solvd.model.Customers;

import java.util.List;

public interface CustomerDAO {

    Customers getCustomerByID(int customerID);

    List<Customers> getAllCustomers();

    void addCustomers(Customers customers);

    void updateCustomers(Customers customers);

    void deleteCustomers(int customerID);


}
