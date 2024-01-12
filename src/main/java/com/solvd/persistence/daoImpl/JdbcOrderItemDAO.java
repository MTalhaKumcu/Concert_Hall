package com.solvd.persistence.daoImpl;

import com.solvd.model.Order;
import com.solvd.model.OrderItem;
import com.solvd.model.Ticket;
import com.solvd.persistence.connection.ConnectionPool;
import com.solvd.persistence.dao.OrderItemDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOrderItemDAO implements OrderItemDAO {

    private final ConnectionPool connectionPool;

    public JdbcOrderItemDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public OrderItem getOrderItemsByID(int orderItemID) {
        OrderItem orderItem = null;
        String query = "SELECT * FROM OrderItems WHERE OrderItemID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, orderItemID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                orderItem = mapResultSetToOrderItem(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItem;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();
        String query = "SELECT * FROM OrderItems";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                OrderItem orderItem = mapResultSetToOrderItem(resultSet);
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItems;
    }


    @Override
    public void addOrderItems(OrderItem orderItem) {
        String query = "INSERT INTO OrderItems (OrderID, TicketID, Quantity, Subtotal) VALUES (?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, orderItem.getOrderItemID());
            statement.setInt(2, orderItem.getTicketID().getTicketID());
            statement.setInt(3, orderItem.getQuantity());
            statement.setDouble(4, orderItem.getSubTotal());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("OrderItem creation failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Assuming OrderItemID is an auto-generated key in the database
                    orderItem.setOrderItemID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("OrderItem creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderItems(OrderItem orderItem) {
        String query = "UPDATE OrderItems SET OrderID = ?, TicketID = ?, Quantity = ?, Subtotal = ? WHERE OrderItemID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, orderItem.getOrderID().getOrderID());
            statement.setInt(2, orderItem.getTicketID().getTicketID());
            statement.setInt(3, orderItem.getQuantity());
            statement.setDouble(4, orderItem.getSubTotal());
            statement.setInt(5, orderItem.getOrderItemID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItems(int orderItemID) {
        String query = "DELETE FROM OrderItems WHERE OrderItemID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, orderItemID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private OrderItem mapResultSetToOrderItem(ResultSet resultSet) throws SQLException {
        int orderItemID = resultSet.getInt("OrderItemID");
        Order orderID = (Order) resultSet.getObject("OrderID");
        Ticket ticketID = (Ticket) resultSet.getObject("TicketID");
        int quantity = resultSet.getInt("Quantity");
        int subtotal = resultSet.getInt("Subtotal");
        return new OrderItem(orderItemID, orderID, ticketID, quantity, subtotal);

    }
}
