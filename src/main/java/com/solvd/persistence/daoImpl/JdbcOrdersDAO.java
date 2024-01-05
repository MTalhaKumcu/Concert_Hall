package com.solvd.persistence.daoImpl;

import com.solvd.model.Orders;
import com.solvd.persistence.dao.OrdersDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOrdersDAO implements OrdersDAO {
    private Connection connection;

    public JdbcOrdersDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Orders getOrderByID(int orderID) {
        Orders order = null;
        String query = "SELECT * FROM Orders WHERE OrderID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
    public List<Orders> getAllOrders() {
        List<Orders> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Orders order = mapResultSetToOrder(resultSet);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public void addOrder(Orders orders) {
        String query = "INSERT INTO Orders (CustomerID, EventID, PurchaseDate, TotalAmount) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, orders.getCustomerID());
            statement.setInt(2, orders.getEventID());
            statement.setDate(3, new java.sql.Date(orders.getPurchaseDate().getTime()));
            statement.setDouble(4, orders.getTotalAmount());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Order creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    orders.setOrderID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Order creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Orders orders) {
        String query = "UPDATE Orders SET CustomerID = ?, EventID = ?, PurchaseDate = ?, TotalAmount = ? WHERE OrderID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orders.getCustomerID());
            statement.setInt(2, orders.getEventID());
            statement.setDate(3, new java.sql.Date(orders.getPurchaseDate().getTime()));
            statement.setDouble(4, orders.getTotalAmount());
            statement.setInt(5, orders.getOrderID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int ordersID) {
        String query = "DELETE FROM Orders WHERE OrderID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, ordersID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Orders mapResultSetToOrder(ResultSet resultSet) throws SQLException {
        int orderID = resultSet.getInt("OrderID");
        int customerID = resultSet.getInt("CustomerID");
        int eventID = resultSet.getInt("EventID");
        Date purchaseDate = resultSet.getDate("PurchaseDate");
        int totalAmount = resultSet.getInt("TotalAmount");
        int paymentMethodID = resultSet.getInt("paymentMethodID");
        return new Orders(orderID, customerID, eventID, purchaseDate, totalAmount, paymentMethodID);

    }
}

