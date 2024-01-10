package com.solvd.service;

import com.solvd.model.OrderItems;
import com.solvd.persistence.dao.OrderItemDAO;

import java.util.List;

public class OrderItemService {
    private final OrderItemDAO orderItemDAO;

    public OrderItems getOrderItemsByID(int orderItemsID) {
        return orderItemDAO.getOrderItemsByID(orderItemsID);
    }

    public List<OrderItems> getAllOrderItems() {
        return orderItemDAO.getAllOrderItems();
    }

    public void addOrderItems(OrderItems orderItems) {
        orderItemDAO.addOrderItems(orderItems);
    }

    public void updateOrderItems(OrderItems orderItems) {
        orderItemDAO.updateOrderItems(orderItems);
    }

    public void deleteOrderItems(int orderItemsID) {
        orderItemDAO.deleteOrderItems(orderItemsID);
    }

    public OrderItemService(OrderItemDAO orderItemDAO) {
        this.orderItemDAO = orderItemDAO;
    }
}
