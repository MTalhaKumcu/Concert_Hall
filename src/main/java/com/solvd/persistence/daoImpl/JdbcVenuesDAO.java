package com.solvd.persistence.daoImpl;

import com.solvd.model.Venues;
import com.solvd.persistence.dao.VenuesDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcVenuesDAO implements VenuesDAO {

    private Connection connection;

    // Constructor: JDBC bağlantısı alınır.
    public JdbcVenuesDAO(Connection connection) {
        this.connection = connection;
    }



    @Override
    public Venues getVenuesByID(int venuesID) {
        Venues venue = null;
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
    public List<Venues> getAllTickets() {
        List<Venues> venues = new ArrayList<>();
        String query = "SELECT * FROM Venues";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Venues venue = mapResultSetToVenue(resultSet);
                venues.add(venue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return venues;
    }

    @Override
    public void addVenues(Venues venues) {
        String query = "INSERT INTO Venues (VenueName, Capacity, Location) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, venues.getVenueName());
            statement.setInt(2, venues.getCapacity());
            statement.setString(3, venues.getLocation());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Venue creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    venues.setVenueID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Venue creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateVenues(Venues venues) {
        String query = "UPDATE Venues SET VenueName = ?, Capacity = ?, Location = ? WHERE VenueID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, venues.getVenueName());
            statement.setInt(2, venues.getCapacity());
            statement.setString(3, venues.getLocation());
            statement.setInt(4, venues.getVenueID());

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
    private Venues mapResultSetToVenue(ResultSet resultSet) throws SQLException {
        int venueID = resultSet.getInt("VenueID");
        String venueName = resultSet.getString("VenueName");
        int capacity = resultSet.getInt("Capacity");
        String location = resultSet.getString("Location");

        return new Venues(venueID, venueName, capacity, location);
    }
}
