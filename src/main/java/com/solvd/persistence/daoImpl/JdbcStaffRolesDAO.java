package com.solvd.persistence.daoImpl;

import com.solvd.model.StaffRoles;
import com.solvd.persistence.dao.StaffRolesDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStaffRolesDAO implements StaffRolesDAO {

    private Connection connection;

    public JdbcStaffRolesDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public StaffRoles getStaffRoleByID(int StaffRolesID) {
        StaffRoles staffRole = null;
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
    public List<StaffRoles> getAllStaffRoles() {
        List<StaffRoles> staffRoles = new ArrayList<>();
        String query = "SELECT * FROM StaffRoles";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                StaffRoles staffRole = mapResultSetToStaffRole(resultSet);
                staffRoles.add(staffRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffRoles;
    }

    @Override
    public void addStaffRole(StaffRoles staffRoles) {
        String query = "INSERT INTO StaffRoles (StaffID, RoleID) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, staffRoles.getStaffID());
            statement.setInt(2, staffRoles.getRoleID());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("StaffRole creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    staffRoles.setStaffRoleID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("StaffRole creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStaffRole(StaffRoles staffRoles) {
        String query = "UPDATE StaffRoles SET StaffID = ?, RoleID = ? WHERE StaffRoleID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, staffRoles.getStaffID());
            statement.setInt(2, staffRoles.getRoleID());
            statement.setInt(3, staffRoles.getStaffRoleID());

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

    private StaffRoles mapResultSetToStaffRole(ResultSet resultSet) throws SQLException{
        int staffRoleID = resultSet.getInt("StaffRoleID");
        int staffID = resultSet.getInt("StaffID");
        int roleID = resultSet.getInt("RoleID");

        return new StaffRoles(staffRoleID, staffID, roleID);
    }
}
