package com.solvd.persistence.daoImpl;

import com.solvd.model.TicketsType;
import com.solvd.persistence.dao.TicketTypeDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTicketTypeDAO implements TicketTypeDAO {

    private Connection connection;

    public JdbcTicketTypeDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public TicketsType getTicketTypeByID(int ticketTypeID) {
        TicketsType ticketType = null;
        String query = "SELECT * FROM TicketTypes WHERE TicketTypeID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, ticketTypeID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ticketType = mapResultSetToTicketType(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticketType;
    }

    @Override
    public List<TicketsType> getAllTicketType() {
        List<TicketsType> ticketTypes = new ArrayList<>();
        String query = "SELECT * FROM TicketTypes";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                TicketsType ticketType = mapResultSetToTicketType(resultSet);
                ticketTypes.add(ticketType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticketTypes;
    }


    @Override
    public void addTicketType(TicketsType ticketsType) {
        String query = "INSERT INTO TicketTypes (TicketTypeName, Description) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, ticketsType.getTicketTypeName());
            statement.setString(2, ticketsType.getDescription());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Ticket type creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    ticketsType.setTicketTypeID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Ticket type creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTicketType(TicketsType ticketsType) {
        String query = "UPDATE TicketTypes SET TicketTypeName = ?, Description = ? WHERE TicketTypeID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ticketsType.getTicketTypeName());
            statement.setString(2, ticketsType.getDescription());
            statement.setInt(3, ticketsType.getTicketTypeID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTicketType(int TicketTypeID) {
        String query = "DELETE FROM TicketTypes WHERE TicketTypeID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, TicketTypeID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private TicketsType mapResultSetToTicketType(ResultSet resultSet)  throws SQLException {

        int ticketTypeID = resultSet.getInt("TicketTypeID");
        String ticketTypeName = resultSet.getString("TicketTypeName");
        String description = resultSet.getString("Description");

        return new TicketsType(ticketTypeID, ticketTypeName, description);

    }


}