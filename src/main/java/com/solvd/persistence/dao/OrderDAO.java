package com.solvd.persistence.dao;

import com.solvd.model.Order;

import java.util.List;

public interface OrderDAO {
    Order getOrderByID(int orderID);

    List<Order> getAllOrders();

    void addOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(int ordersID);

}
