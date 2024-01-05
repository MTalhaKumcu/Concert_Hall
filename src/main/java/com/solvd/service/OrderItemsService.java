package com.solvd.service;

import com.solvd.model.OrderItems;
import com.solvd.persistence.dao.OrderItemsDAO;

import java.util.List;

public class OrderItemsService {
    private final OrderItemsDAO orderItemsDAO;

    public OrderItems getOrderItemsByID(int orderItemsID) {
        return orderItemsDAO.getOrderItemsByID(orderItemsID);
    }

    public List<OrderItems> getAllOrderItems() {
        return orderItemsDAO.getAllOrderItems();
    }

    public void addOrderItems(OrderItems orderItems) {
        orderItemsDAO.addOrderItems(orderItems);
    }

    public void updateOrderItems(OrderItems orderItems) {
        orderItemsDAO.updateOrderItems(orderItems);
    }

    public void deleteOrderItems(int orderItemsID) {
        orderItemsDAO.deleteOrderItems(orderItemsID);
    }

    public OrderItemsService(OrderItemsDAO orderItemsDAO) {
        this.orderItemsDAO = orderItemsDAO;
    }
}
