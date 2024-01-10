package com.solvd.service;

import com.solvd.model.Orders;
import com.solvd.persistence.dao.OrderDAO;

import java.util.List;

public class OrderService {

    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    public void addOrder(Orders order) {
        orderDAO.addOrder(order);
    }

    public void updateOrder(Orders order) {
        orderDAO.updateOrder(order);
    }

    public void deleteOrder(int orderID) {
        orderDAO.deleteOrder(orderID);
    }

    public Orders getOrderByID(int orderID) {
        return orderDAO.getOrderByID(orderID);
    }

    public List<Orders> getAllOrders() {
        return orderDAO.getAllOrders();
    }

}
