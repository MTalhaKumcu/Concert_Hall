package com.solvd.persistence.daoImpl;

import com.solvd.model.Venue;
import com.solvd.persistence.dao.VenueDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcVenueDAO implements VenueDAO {

    private Connection connection;

    // Constructor: JDBC bağlantısı alınır.
    public JdbcVenueDAO(Connection connection) {
        this.connection = connection;
    }



    @Override
    public Venue getVenuesByID(int venuesID) {
        Venue venue = null;
        String query = "SELECT * FROM Venues WHERE VenueID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, venuesID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                venue = mapResultSetToVenue(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return venue;
    }



    @Override
    public List<Venue> getAllTickets() {
        List<Venue> venues = new ArrayList<>();
        String query = "SELECT * FROM Venues";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Venue venue = mapResultSetToVenue(resultSet);
                venues.add(venue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return venues;
    }

    @Override
    public void addVenues(Venue venue) {
        String query = "INSERT INTO Venues (VenueName, Capacity, Location) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, venue.getVenueName());
            statement.setInt(2, venue.getCapacity());
            statement.setString(3, venue.getLocation());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Venue creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    venue.setVenueID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Venue creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateVenues(Venue venue) {
        String query = "UPDATE Venues SET VenueName = ?, Capacity = ?, Location = ? WHERE VenueID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, venue.getVenueName());
            statement.setInt(2, venue.getCapacity());
            statement.setString(3, venue.getLocation());
            statement.setInt(4, venue.getVenueID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVenues(int venuesID) {
        String query = "DELETE FROM Venues WHERE VenueID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, venuesID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Venue mapResultSetToVenue(ResultSet resultSet) throws SQLException {
        int venueID = resultSet.getInt("VenueID");
        String venueName = resultSet.getString("VenueName");
        int capacity = resultSet.getInt("Capacity");
        String location = resultSet.getString("Location");

        return new Venue(venueID, venueName, capacity, location);
    }
}
