package com.solvd.persistence.daoImpl;

import com.solvd.model.PaymentsMethods;
import com.solvd.persistence.dao.PaymentMethodDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPaymentMethodDAO implements PaymentMethodDAO {

    private Connection connection;


    public JdbcPaymentMethodDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public PaymentsMethods getPaymentsMethodsByID(int paymentsMethodID) {
        PaymentsMethods paymentMethod = null;
        String query = "SELECT * FROM PaymentMethods WHERE PaymentMethodID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, paymentsMethodID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                paymentMethod = mapResultSetToPaymentMethod(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentMethod;
    }



    @Override
    public List<PaymentsMethods> getAllPaymentMethods() {
        List<PaymentsMethods> paymentMethods = new ArrayList<>();
        String query = "SELECT * FROM PaymentMethods";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                PaymentsMethods paymentMethod = mapResultSetToPaymentMethod(resultSet);
                paymentMethods.add(paymentMethod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentMethods;
    }

    @Override
    public void addPaymentMethod(PaymentsMethods paymentsMethods) {
        String query = "INSERT INTO PaymentMethods (MethodName, Description) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, PaymentsMethods.getDescription());
            statement.setString(2, PaymentsMethods.getDescription());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("PaymentMethod creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    PaymentsMethods.setPaymentMethodID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("PaymentMethod creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePaymentMethod(PaymentsMethods paymentsMethods) {
        String query = "UPDATE PaymentMethods SET MethodName = ?, Description = ? WHERE PaymentMethodID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, PaymentsMethods.getPaymentMethodName());
            statement.setString(2, PaymentsMethods.getDescription());
            statement.setInt(3, PaymentsMethods.getPaymentMethodID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePaymentMethod(int paymentMethodID) {
        String query = "DELETE FROM PaymentMethods WHERE PaymentMethodID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, paymentMethodID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private PaymentsMethods mapResultSetToPaymentMethod(ResultSet resultSet) throws SQLException {
        int paymentMethodID = resultSet.getInt("PaymentMethodID");
        String methodName = resultSet.getString("MethodName");
        String description = resultSet.getString("Description");

        return new PaymentsMethods(paymentMethodID, methodName, description);
    }
}
