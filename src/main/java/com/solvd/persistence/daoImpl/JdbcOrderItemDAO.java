package com.solvd.persistence.daoImpl;

import com.solvd.model.OrderItem;
import com.solvd.persistence.dao.OrderItemDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOrderItemDAO implements OrderItemDAO {

    private Connection connection;
    public JdbcOrderItemDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public OrderItem getOrderItemsByID(int orderItemsID) {
        OrderItem orderItem = null;
        String query = "SELECT * FROM OrderItems WHERE OrderItemID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderItemsID);
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

        try (Statement statement = connection.createStatement();
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

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, orderItem.getOrderID());
            statement.setInt(2, orderItem.getTicketID());
            statement.setInt(3, orderItem.getQuantity());
            statement.setDouble(4, orderItem.getSubTotal());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("OrderItem creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
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

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderItem.getOrderID());
            statement.setInt(2, orderItem.getTicketID());
            statement.setInt(3, orderItem.getQuantity());
            statement.setDouble(4, orderItem.getSubTotal());
            statement.setInt(5, orderItem.getOrderItemID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItems(int orderItemsID) {
        String query = "DELETE FROM OrderItems WHERE OrderItemID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderItemsID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private OrderItem mapResultSetToOrderItem(ResultSet resultSet) throws SQLException {
        int orderItemID = resultSet.getInt("OrderItemID");
        int orderID = resultSet.getInt("OrderID");
        int ticketID = resultSet.getInt("TicketID");
        int quantity = resultSet.getInt("Quantity");
        int subTotal = resultSet.getInt("Subtotal");

        return new OrderItem(orderItemID, orderID, ticketID, quantity, subTotal);
    }
}
