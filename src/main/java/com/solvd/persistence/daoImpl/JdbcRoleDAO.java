package com.solvd.persistence.daoImpl;

import com.solvd.model.Role;
import com.solvd.persistence.connection.ConnectionPool;
import com.solvd.persistence.dao.RoleDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRoleDAO implements RoleDAO {
    private final ConnectionPool connectionPool;

    public JdbcRoleDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Role getRoleByID(int roleID) {
        Role role = null;
        String query = "SELECT * FROM Roles WHERE RoleID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, roleID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                role = mapResultSetToRole(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        String query = "SELECT * FROM Roles";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Role role = mapResultSetToRole(resultSet);
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;    }

    @Override
    public void addRole(Role role) {
        String query = "INSERT INTO Roles (RoleName, Description) VALUES (?, ?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, role.getRoleName());
            statement.setString(2, role.getDescription());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Role creation failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Assuming RoleID is an auto-generated key in the database
                    role.setRoleID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Role creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRole(Role role) {
        String query = "UPDATE Roles SET RoleName = ?, Description = ? WHERE RoleID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, role.getRoleName());
            statement.setString(2, role.getDescription());
            statement.setInt(3, role.getRoleID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRole(int roleID) {
        String query = "DELETE FROM Roles WHERE RoleID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, roleID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Role mapResultSetToRole(ResultSet resultSet) throws SQLException {
        int roleID = resultSet.getInt("RoleID");
        String roleName = resultSet.getString("RoleName");
        String description = resultSet.getString("Description");

        return new Role(roleID, roleName, description);
    }
}
