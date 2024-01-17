package com.solvd.service.JdbcDaoService;

import com.solvd.model.Order;
import com.solvd.persistence.dao.OrderDAO;

import java.util.List;

public class OrderService {

    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    public void deleteOrder(int orderID) {
        orderDAO.deleteOrder(orderID);
    }

    public Order getOrderByID(int orderID) {
        return orderDAO.getOrderByID(orderID);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

}
