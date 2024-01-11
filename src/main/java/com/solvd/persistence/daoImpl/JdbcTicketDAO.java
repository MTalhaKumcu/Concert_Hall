package com.solvd.persistence.daoImpl;

import com.solvd.model.Ticket;
import com.solvd.persistence.dao.TicketDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTicketDAO implements TicketDAO {
    private Connection connection;

    public JdbcTicketDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Ticket getTicketByID(int ticketID) {
        Ticket ticket = null;
        String query = "SELECT * FROM Tickets WHERE TicketID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String query = "SELECT * FROM Tickets";

        try (Statement statement = connection.createStatement();
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

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, ticket.getEventID());
            statement.setDouble(2, ticket.getPrice());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Ticket creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
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

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, ticket.getEventID());
            statement.setDouble(2, ticket.getPrice());
            statement.setInt(4, ticket.getTicketID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTicket(int ticketID) {
        String query = "DELETE FROM Tickets WHERE TicketID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, ticketID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Ticket mapResultSetToTicket(ResultSet resultSet) throws SQLException {
        int ticketID = resultSet.getInt("TicketID");
        int eventID = resultSet.getInt("EventID");
        int price = resultSet.getInt("Price");

        return new Ticket(ticketID, eventID, price);
    }

}
