package com.solvd.persistence.mybatis;

import com.solvd.model.OrderItem;
import com.solvd.persistence.connection.MyBatisConnection;
import com.solvd.persistence.dao.OrderItemDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderItemMybatis implements OrderItemDAO {
    @Override
    public OrderItem getOrderItemsByID(int orderItemID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectOne("com.solvd.persistence.dao.OrderItemDAO.getOrderItemById", orderItemID);
        }
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            return session.selectList("com.solvd.persistence.dao.OrderItemDAO.getAllOrderItems");
        }    }

    @Override
    public void addOrderItems(OrderItem orderItem) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.insert("com.solvd.persistence.dao.OrderItemDAO.addOrderItem", orderItem);
            session.commit();
        }
    }

    @Override
    public void updateOrderItems(OrderItem orderItem) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.update("com.solvd.persistence.dao.OrderItemDAO.updateOrderItem", orderItem);
            session.commit();
        }
    }

    @Override
    public void deleteOrderItems(int orderItemID) {
        try (SqlSession session = MyBatisConnection.getSqlSessionFactory().openSession()) {
            session.delete("com.solvd.persistence.dao.OrderItemDAO.deleteOrderItem", orderItemID);
            session.commit();
        }
    }
}
