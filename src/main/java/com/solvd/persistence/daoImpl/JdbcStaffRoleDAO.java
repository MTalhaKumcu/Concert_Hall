package com.solvd.persistence.daoImpl;

import com.solvd.model.StaffRole;
import com.solvd.persistence.dao.StaffRoleDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStaffRoleDAO implements StaffRoleDAO {

    private Connection connection;

    public JdbcStaffRoleDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public StaffRole getStaffRoleByID(int StaffRolesID) {
        StaffRole staffRole = null;
        String query = "SELECT * FROM StaffRoles WHERE StaffRoleID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, StaffRolesID);
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

        try (Statement statement = connection.createStatement();
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

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, staffRole.getStaffID());
            statement.setInt(2, staffRole.getRoleID());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("StaffRole creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
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

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, staffRole.getStaffID());
            statement.setInt(2, staffRole.getRoleID());
            statement.setInt(3, staffRole.getStaffRoleID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStaffRole(int staffRolesID) {
        String query = "DELETE FROM StaffRoles WHERE StaffRoleID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, staffRolesID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private StaffRole mapResultSetToStaffRole(ResultSet resultSet) throws SQLException{
        int staffRoleID = resultSet.getInt("StaffRoleID");
        int staffID = resultSet.getInt("StaffID");
        int roleID = resultSet.getInt("RoleID");

        return new StaffRole(staffRoleID, staffID, roleID);
    }
}
