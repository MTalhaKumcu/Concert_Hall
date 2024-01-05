package com.solvd.persistence.daoImpl;

import com.solvd.model.Staffs;
import com.solvd.persistence.dao.StaffsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStaffsDAO implements StaffsDAO {

    private Connection connection;

    public JdbcStaffsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Staffs getStaffByID(int StaffID) {
        Staffs staff = null;
        String query = "SELECT * FROM Staff WHERE StaffID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, StaffID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                staff = mapResultSetToStaff(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staff;
    }


    @Override
    public List<Staffs> getAllStaffs() {
        List<Staffs> staffList = new ArrayList<>();
        String query = "SELECT * FROM Staff";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Staffs staff = mapResultSetToStaff(resultSet);
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffList;    }

    @Override
    public void addStaff(Staffs staffs) {
        String query = "INSERT INTO Staff (FirstName, LastName, Position) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, staffs.getFirstName());
            statement.setString(2, staffs.getLastName());
            statement.setString(3, staffs.getPosition());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Staff creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    staffs.setStaffID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Staff creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStaff(Staffs staffs) {
        String query = "UPDATE Staff SET FirstName = ?, LastName = ?, Position = ? WHERE StaffID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, staffs.getFirstName());
            statement.setString(2, staffs.getLastName());
            statement.setString(3, staffs.getPosition());
            statement.setInt(4, staffs.getStaffID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStaff(int StaffID) {
        String query = "DELETE FROM Staff WHERE StaffID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, StaffID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private Staffs mapResultSetToStaff(ResultSet resultSet) throws SQLException{
        int staffID = resultSet.getInt("StaffID");
        String firstName = resultSet.getString("FirstName");
        String lastName = resultSet.getString("LastName");
        String position = resultSet.getString("Position");

        return new Staffs(staffID, firstName, lastName, position);
    }
}
