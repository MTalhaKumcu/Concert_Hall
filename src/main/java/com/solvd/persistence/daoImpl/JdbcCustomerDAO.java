package com.solvd.persistence.daoImpl;

import com.solvd.model.Customer;
import com.solvd.persistence.dao.CustomerDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDAO implements CustomerDAO {

    private Connection connection;

    public JdbcCustomerDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Customer getCustomerByID(int customerID) {
        Customer customer = null;
        String query = "SELECT * FROM Customers WHERE CustomerID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                customer = mapResultSetToCustomer(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }



    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customers";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Customer customer = mapResultSetToCustomer(resultSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    @Override
    public void addCustomers(Customer customer) {
        String query = "INSERT INTO Customers (FirstName, LastName, Email, PhoneNumber) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Customer creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setCustomerID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Customer creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomers(Customer customer) {
        String query = "UPDATE Customers SET FirstName = ?, LastName = ?, Email = ? WHERE CustomerID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setInt(5, customer.getCustomerID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomers(int customerID) {
        String query = "DELETE FROM Customers WHERE CustomerID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private Customer mapResultSetToCustomer(ResultSet resultSet) throws SQLException {
        int customerID = resultSet.getInt("CustomerID");
        String firstName = resultSet.getString("FirstName");
        String lastName = resultSet.getString("LastName");
        String email = resultSet.getString("Email");


        return new Customer(customerID, firstName, lastName, email);
    }
}
