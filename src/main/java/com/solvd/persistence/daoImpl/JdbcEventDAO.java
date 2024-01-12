package com.solvd.persistence.daoImpl;

import com.solvd.model.Event;
import com.solvd.persistence.connection.ConnectionPool;
import com.solvd.persistence.dao.EventDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEventDAO implements EventDAO {
    private final ConnectionPool connectionPool;

    public JdbcEventDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Event getEventByID(int eventsID) {
        Event event = null;
        String query = "SELECT * FROM Events WHERE EventName = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, eventsID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                event = mapResultSetToEvent(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM Events";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Event event = mapResultSetToEvent(resultSet);
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public void addEvent(Event event) {
        String query = "INSERT INTO Events (EventName, VenueID, EventDate, StartTime, EndTime) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, event.getEventName());
            statement.setInt(2, event.getVenueID().getVenueID());
            statement.setDate(3, new java.sql.Date(event.getEventDate().getTime()));
            statement.setTime(4, new java.sql.Time(event.getStartTime().getTime()));
            statement.setTime(5, new java.sql.Time(event.getEndTime().getTime()));

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Event creation failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Assuming EventID is an auto-generated key in the database
                    event.setEventID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Event creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEvent(Event event) {
        String query = "UPDATE Events SET EventName = ?, VenueID = ?, EventDate = ?, StartTime = ?, EndTime = ? WHERE EventID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, event.getEventName());
            statement.setInt(2, event.getVenueID().getVenueID());
            statement.setDate(3, new java.sql.Date(event.getEventDate().getTime()));
            statement.setTime(4, new java.sql.Time(event.getStartTime().getTime()));
            statement.setTime(5, new java.sql.Time(event.getEndTime().getTime()));
            statement.setInt(6, event.getEventID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEvent(int eventID) {
        String query = "DELETE FROM Events WHERE EventID = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, eventID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Event mapResultSetToEvent(ResultSet resultSet) throws SQLException {
        int eventID = resultSet.getInt("EventID");
        String eventName = resultSet.getString("EventName");
        Date eventDate = resultSet.getDate("EventDate");
        Time startTime = resultSet.getTime("StartTime");
        Time endTime = resultSet.getTime("EndTime");


        return new Event(eventID, eventName ,eventDate, startTime, endTime);

    }
}
