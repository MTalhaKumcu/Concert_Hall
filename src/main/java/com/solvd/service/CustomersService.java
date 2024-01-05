package com.solvd.service;

import com.solvd.model.Customers;
import com.solvd.persistence.dao.CustomerDAO;

import java.util.List;

public class CustomersService {
    private final CustomerDAO customerDAO;

    public CustomersService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    public void addCustomer(Customers customer) {
        customerDAO.addCustomers(customer);
    }

    public void updateCustomer(Customers customer) {
        customerDAO.updateCustomers(customer);
    }

    public void deleteCustomer(int customerID) {
        customerDAO.deleteCustomers(customerID);
    }

    public Customers getCustomerByID(int customerID) {
        return customerDAO.getCustomerByID(customerID);
    }

    public List<Customers> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

}
