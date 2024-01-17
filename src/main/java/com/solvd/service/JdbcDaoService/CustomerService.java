package com.solvd.service.JdbcDaoService;

import com.solvd.model.Customer;
import com.solvd.persistence.dao.CustomerDAO;

import java.util.List;

public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    public void addCustomer(Customer customer) {
        customerDAO.addCustomers(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomers(customer);
    }

    public void deleteCustomer(int customerID) {
        customerDAO.deleteCustomers(customerID);
    }

    public Customer getCustomerByID(int customerID) {
        return customerDAO.getCustomerByID(customerID);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

}
