package com.solvd.persistence.daoImpl;

import com.solvd.model.Staff;
import com.solvd.persistence.dao.StaffDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStaffDAO implements StaffDAO {

    private Connection connection;

    public JdbcStaffDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Staff getStaffByID(int StaffID) {
        Staff staff = null;
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
    public List<Staff> getAllStaffs() {
        List<Staff> staffList = new ArrayList<>();
        String query = "SELECT * FROM Staff";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Staff staff = mapResultSetToStaff(resultSet);
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffList;    }

    @Override
    public void addStaff(Staff staff) {
        String query = "INSERT INTO Staff (FirstName, LastName, Position) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, staff.getFirstName());
            statement.setString(2, staff.getLastName());
            statement.setString(3, staff.getPosition());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Staff creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    staff.setStaffID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Staff creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStaff(Staff staff) {
        String query = "UPDATE Staff SET FirstName = ?, LastName = ?, Position = ? WHERE StaffID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, staff.getFirstName());
            statement.setString(2, staff.getLastName());
            statement.setString(3, staff.getPosition());
            statement.setInt(4, staff.getStaffID());

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



    private Staff mapResultSetToStaff(ResultSet resultSet) throws SQLException{
        int staffID = resultSet.getInt("StaffID");
        String firstName = resultSet.getString("FirstName");
        String lastName = resultSet.getString("LastName");
        String position = resultSet.getString("Position");

        return new Staff(staffID, firstName, lastName, position);
    }
}
