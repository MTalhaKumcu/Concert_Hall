package com.solvd.persistence.daoImpl;

import com.solvd.model.Tickets;
import com.solvd.persistence.dao.TicketsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTicketsDAO implements TicketsDAO {
    private Connection connection;

    public JdbcTicketsDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Tickets getTicketByID(int ticketID) {
        Tickets ticket = null;
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
    public List<Tickets> getAllTickets() {
        List<Tickets> tickets = new ArrayList<>();
        String query = "SELECT * FROM Tickets";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Tickets ticket = mapResultSetToTicket(resultSet);
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    @Override
    public void addTicket(Tickets tickets) {
        String query = "INSERT INTO Tickets (EventID, Price, TicketType) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, tickets.getTicketEventID());
            statement.setDouble(2, tickets.getPrice());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Ticket creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    tickets.setTicketID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Ticket creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTicket(Tickets tickets) {
        String query = "UPDATE Tickets SET EventID = ?, Price = ?, TicketType = ? WHERE TicketID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, tickets.getTicketEventID());
            statement.setDouble(2, tickets.getPrice());
            statement.setInt(4, tickets.getTicketID());

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

    private Tickets mapResultSetToTicket(ResultSet resultSet) throws SQLException {
        int ticketID = resultSet.getInt("TicketID");
        int eventID = resultSet.getInt("EventID");
        int price = resultSet.getInt("Price");

        return new Tickets(ticketID, eventID, price);
    }

}
