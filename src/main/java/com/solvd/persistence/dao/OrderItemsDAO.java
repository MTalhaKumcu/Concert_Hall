package com.solvd.persistence.dao;

import com.solvd.model.OrderItems;

import java.util.List;

public interface OrderItemsDAO {
    OrderItems getOrderItemsByID(int orderItemsID);
    List<OrderItems> getAllOrderItems();
    void addOrderItems(OrderItems orderItems);
    void updateOrderItems(OrderItems orderItems);
    void deleteOrderItems(int orderItemsID);
}
