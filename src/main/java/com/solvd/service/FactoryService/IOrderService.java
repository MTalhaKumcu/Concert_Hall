package com.solvd.service.FactoryService;

import com.solvd.model.Order;

public interface IOrderService {
    Order createOrderService(Order order);

    Order getOrderByID(int OrderID);
}
