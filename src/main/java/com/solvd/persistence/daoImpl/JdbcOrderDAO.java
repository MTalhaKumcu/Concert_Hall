package com.solvd.persistence.daoImpl;

import com.solvd.model.Customer;
import com.solvd.model.Event;
import com.solvd.model.Order;
import com.solvd.persistence.connection.ConnectionPool;
import com.solvd.persistence.dao.OrderDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOrderDAO implements OrderDAO {
    private final ConnectionPool connectionPool;

    public JdbcOrderDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Order getOrderByID(int orderID) {
        Order order = null;
        String query = "SELECT * FROM Orders WHERE OrderID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, orderID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                order = mapResultSetToOrder(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Order order = mapResultSetToOrder(resultSet);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public void addOrder(Order order) {
        String query = "INSERT INTO Orders (CustomerID, EventID, PurchaseDate, TotalAmount) VALUES (?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setObject(1, order.getCustomerID());
            statement.setObject(2, order.getEventID());
            statement.setDate(3, new java.sql.Date(order.getPurchaseDate().getTime()));
            statement.setDouble(4, order.getTotalAmount());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Order creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Assuming OrderID is an auto-generated key in the database
                    order.setOrderID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Order creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Order order) {
        String query = "UPDATE Orders SET CustomerID = ?, EventID = ?, PurchaseDate = ?, TotalAmount = ? WHERE OrderID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setObject(1, order.getCustomerID());
            statement.setObject(2, order.getEventID());
            statement.setDate(3, new java.sql.Date(order.getPurchaseDate().getTime()));
            statement.setDouble(4, order.getTotalAmount());
            statement.setInt(5, order.getOrderID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderID) {
        String query = "DELETE FROM Orders WHERE OrderID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, orderID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Order mapResultSetToOrder(ResultSet resultSet) throws SQLException {
        int orderID = resultSet.getInt("OrderID");
        int customerID = resultSet.getInt("CustomerID");
        int eventID = resultSet.getInt("EventID");
        Date purchaseDate = resultSet.getDate("PurchaseDate");
        int totalAmount = resultSet.getInt("TotalAmount");

        Customer customer = new Customer(customerID);
        Event event = new Event(eventID);

        return new Order(orderID, customer, event, purchaseDate, totalAmount);

    }

}

