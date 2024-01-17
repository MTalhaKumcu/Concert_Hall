package com.solvd.service.MybatisService;

import com.solvd.model.OrderItem;
import com.solvd.persistence.dao.OrderItemDAO;

import java.util.List;

public class OrderItemService {
    private final OrderItemDAO orderItemDAO;

    public OrderItem getOrderItemsByID(int orderItemsID) {
        return orderItemDAO.getOrderItemsByID(orderItemsID);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemDAO.getAllOrderItems();
    }

    public void addOrderItems(OrderItem orderItem) {
        orderItemDAO.addOrderItems(orderItem);
    }

    public void updateOrderItems(OrderItem orderItem) {
        orderItemDAO.updateOrderItems(orderItem);
    }

    public void deleteOrderItems(int orderItemsID) {
        orderItemDAO.deleteOrderItems(orderItemsID);
    }

    public OrderItemService(OrderItemDAO orderItemDAO) {
        this.orderItemDAO = orderItemDAO;
    }
}
