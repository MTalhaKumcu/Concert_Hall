package com.solvd.persistence.dao;

import com.solvd.model.Orders;

import java.util.List;

public interface OrderDAO {
    Orders getOrderByID(int orderID);

    List<Orders> getAllOrders();

    void addOrder(Orders orders);

    void updateOrder(Orders orders);

    void deleteOrder(int ordersID);

}
