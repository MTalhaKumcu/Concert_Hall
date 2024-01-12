package com.solvd.persistence.daoImpl;

import com.solvd.model.PaymentsMethod;
import com.solvd.persistence.connection.ConnectionPool;
import com.solvd.persistence.dao.PaymentMethodDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPaymentMethodDAO implements PaymentMethodDAO {

    private final ConnectionPool connectionPool;

    public JdbcPaymentMethodDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    @Override
    public PaymentsMethod getPaymentsMethodsByID(int paymentMethodID) {
        PaymentsMethod paymentMethod = null;
        String query = "SELECT * FROM PaymentMethods WHERE PaymentMethodID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, paymentMethodID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                paymentMethod = mapResultSetToPaymentMethod(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentMethod;    }


    @Override
    public List<PaymentsMethod> getAllPaymentMethods() {
        List<PaymentsMethod> paymentMethods = new ArrayList<>();
        String query = "SELECT * FROM PaymentMethods";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                PaymentsMethod paymentMethod = mapResultSetToPaymentMethod(resultSet);
                paymentMethods.add(paymentMethod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentMethods;    }

    @Override
    public void addPaymentMethod(PaymentsMethod paymentMethod) {
        String query = "INSERT INTO PaymentMethods (MethodName, Description) VALUES (?, ?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, paymentMethod.getPaymentMethodName());
            statement.setString(2, paymentMethod.getDescription());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("PaymentMethod creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Assuming PaymentMethodID is an auto-generated key in the database
                    paymentMethod.setPaymentMethodID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("PaymentMethod creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePaymentMethod(PaymentsMethod paymentMethod) {
        String query = "UPDATE PaymentMethods SET MethodName = ?, Description = ? WHERE PaymentMethodID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, paymentMethod.getPaymentMethodName());
            statement.setString(2, paymentMethod.getDescription());
            statement.setInt(3, paymentMethod.getPaymentMethodID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePaymentMethod(int paymentMethodID) {
        String query = "DELETE FROM PaymentMethods WHERE PaymentMethodID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, paymentMethodID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private PaymentsMethod mapResultSetToPaymentMethod(ResultSet resultSet) throws SQLException {
        int paymentMethodID = resultSet.getInt("PaymentMethodID");
        String methodName = resultSet.getString("MethodName");
        String description = resultSet.getString("Description");

        return new PaymentsMethod(paymentMethodID, methodName, description);

    }

}
