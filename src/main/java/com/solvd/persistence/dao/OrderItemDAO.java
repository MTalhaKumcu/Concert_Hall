package com.solvd.persistence.dao;

import com.solvd.model.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    OrderItem getOrderItemsByID(int orderItemsID);
    List<OrderItem> getAllOrderItems();
    void addOrderItems(OrderItem orderItem);
    void updateOrderItems(OrderItem orderItem);
    void deleteOrderItems(int orderItemsID);
}
