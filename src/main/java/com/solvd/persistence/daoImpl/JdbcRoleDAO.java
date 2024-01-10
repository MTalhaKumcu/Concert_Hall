package com.solvd.persistence.daoImpl;

import com.solvd.model.Roles;
import com.solvd.persistence.dao.RoleDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRoleDAO implements RoleDAO {
    private Connection connection;

    public JdbcRoleDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Roles getRoleByID(int roleID) {
        Roles role = null;
        String query = "SELECT * FROM Roles WHERE RoleID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
    public List<Roles> getAllRoles() {
        List<Roles> roles = new ArrayList<>();
        String query = "SELECT * FROM Roles";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Roles role = mapResultSetToRole(resultSet);
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;

    }

    @Override
    public void addRole(Roles roles) {
        String query = "INSERT INTO Roles (RoleName, Description) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, roles.getRoleName());
            statement.setString(2, roles.getDescription());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Role creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    roles.setRoleID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Role creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRole(Roles roles) {
        String query = "UPDATE Roles SET RoleName = ?, Description = ? WHERE RoleID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, roles.getRoleName());
            statement.setString(2, roles.getDescription());
            statement.setInt(3, roles.getRoleID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRole(int roleID) {
        String query = "DELETE FROM Roles WHERE RoleID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, roleID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Roles mapResultSetToRole(ResultSet resultSet) throws SQLException {
        {
            int roleID = resultSet.getInt("RoleID");
            String roleName = resultSet.getString("RoleName");
            String description = resultSet.getString("Description");

            return new Roles(roleID, roleName, description);
        }
    }
}
