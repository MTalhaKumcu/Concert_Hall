package com.solvd.service;

import com.solvd.model.Orders;
import com.solvd.persistence.dao.OrdersDAO;

import java.util.List;

public class OrdersService {

    private final OrdersDAO ordersDAO;

    public OrdersService(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }
    public void addOrder(Orders order) {
        ordersDAO.addOrder(order);
    }

    public void updateOrder(Orders order) {
        ordersDAO.updateOrder(order);
    }

    public void deleteOrder(int orderID) {
        ordersDAO.deleteOrder(orderID);
    }

    public Orders getOrderByID(int orderID) {
        return ordersDAO.getOrderByID(orderID);
    }

    public List<Orders> getAllOrders() {
        return ordersDAO.getAllOrders();
    }

}
