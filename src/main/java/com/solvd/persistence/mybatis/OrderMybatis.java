package com.solvd.persistence.mybatis;

import com.solvd.model.Order;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.OrderDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderMybatis implements OrderDAO {
    @Override
    public Order getOrderByID(int orderID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.OrderDAO.getOrderById", orderID);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.OrderDAO.getAllOrders");
        }
    }

    @Override
    public void addOrder(Order order) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.OrderDAO.addOrder", order);
            session.commit();
        }
    }

    @Override
    public void updateOrder(Order order) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.OrderDAO.updateOrder", order);
            session.commit();
        }
    }

    @Override
    public void deleteOrder(int ordersID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.OrderDAO.deleteOrder", ordersID);
            session.commit();
        }
    }
}
