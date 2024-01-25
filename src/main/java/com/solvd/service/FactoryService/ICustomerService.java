package com.solvd.service.FactoryService;

import com.solvd.model.Customer;

public interface ICustomerService {
  Customer createCustomer(Customer customer);

  Customer getCustomerByID(int CustomerID);
}
