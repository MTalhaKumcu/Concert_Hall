package com.solvd.persistence.daoImpl;

import com.solvd.model.Event;
import com.solvd.model.Ticket;
import com.solvd.model.TicketsType;
import com.solvd.persistence.connection.ConnectionPool;
import com.solvd.persistence.dao.TicketDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTicketDAO implements TicketDAO {
    private final ConnectionPool connectionPool;

    public JdbcTicketDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Ticket getTicketByID(int ticketID) {
        Ticket ticket = null;
        String query = "SELECT * FROM Tickets WHERE TicketID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, ticketID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ticket = mapResultSetToTicket(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticket;
    }

    @Override
    public List<Ticket> getAllTicket() {
        List<Ticket> tickets = new ArrayList<>();
        String query = "SELECT * FROM Tickets";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Ticket ticket = mapResultSetToTicket(resultSet);
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    @Override
    public void addTicket(Ticket ticket) {
        String query = "INSERT INTO Tickets (EventID, Price, TicketType) VALUES (?, ?, ?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, ticket.getEventID().getEventID());
            statement.setDouble(2, ticket.getPrice());
            statement.setInt(3, ticket.getTicketTypeID().getTicketTypeID());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Ticket creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Assuming TicketID is an auto-generated key in the database
                    ticket.setTicketID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Ticket creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTicket(Ticket ticket) {
        String query = "UPDATE Tickets SET EventID = ?, Price = ?, TicketType = ? WHERE TicketID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, ticket.getEventID().getEventID());
            statement.setDouble(2, ticket.getPrice());
            statement.setInt(3, ticket.getTicketTypeID().getTicketTypeID());
            statement.setInt(4, ticket.getTicketID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTicket(int ticketID) {
        String query = "DELETE FROM Tickets WHERE TicketID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, ticketID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Ticket mapResultSetToTicket(ResultSet resultSet) throws SQLException {
        int ticketID = resultSet.getInt("TicketID");
        int eventID = resultSet.getInt("EventID");
        double price = resultSet.getDouble("Price");
        int ticketTypeID = resultSet.getInt("TicketTypeID");



        Event event = new Event(eventID);
        TicketsType ticketsType = new TicketsType(ticketTypeID);
        return new Ticket(ticketID, event, price, ticketsType);

    }
}
