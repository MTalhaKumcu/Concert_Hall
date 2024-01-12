package com.solvd.persistence.daoImpl;

import com.solvd.model.Role;
import com.solvd.model.Staff;
import com.solvd.model.StaffRole;
import com.solvd.persistence.connection.ConnectionPool;
import com.solvd.persistence.dao.StaffRoleDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStaffRoleDAO implements StaffRoleDAO {
    private final ConnectionPool connectionPool;

    public JdbcStaffRoleDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public StaffRole getStaffRoleByID(int staffRoleID) {
        StaffRole staffRole = null;
        String query = "SELECT * FROM StaffRoles WHERE StaffRoleID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, staffRoleID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                staffRole = mapResultSetToStaffRole(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffRole;
    }

    @Override
    public List<StaffRole> getAllStaffRoles() {
        List<StaffRole> staffRoles = new ArrayList<>();
        String query = "SELECT * FROM StaffRoles";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                StaffRole staffRole = mapResultSetToStaffRole(resultSet);
                staffRoles.add(staffRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffRoles;
    }

    @Override
    public void addStaffRole(StaffRole staffRole) {
        String query = "INSERT INTO StaffRoles (StaffID, RoleID) VALUES (?, ?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, staffRole.getStaffID().getStaffID());
            statement.setInt(2, staffRole.getRoleID().getRoleID());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("StaffRole creation failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Assuming StaffRoleID is an auto-generated key in the database
                    staffRole.setStaffRoleID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("StaffRole creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStaffRole(StaffRole staffRole) {
        String query = "UPDATE StaffRoles SET StaffID = ?, RoleID = ? WHERE StaffRoleID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, staffRole.getStaffID().getStaffID());
            statement.setInt(2, staffRole.getRoleID().getRoleID());
            statement.setInt(3, staffRole.getStaffRoleID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStaffRole(int staffRoleID) {
        String query = "DELETE FROM StaffRoles WHERE StaffRoleID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, staffRoleID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private StaffRole mapResultSetToStaffRole(ResultSet resultSet) throws SQLException {
        int staffRoleID = resultSet.getInt("StaffRoleID");
        int staffID = resultSet.getInt("StaffID");
        int roleID = resultSet.getInt("RoleID");

        Staff staff = getStaffRoleByID(staffID).getStaffID();
        Role role = getStaffRoleByID(roleID).getRoleID();

        return new StaffRole(staffRoleID, staff, role);

    }
}
