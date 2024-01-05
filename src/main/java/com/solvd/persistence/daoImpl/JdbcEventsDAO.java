package com.solvd.persistence.daoImpl;

import com.solvd.model.Events;
import com.solvd.persistence.dao.EventsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEventsDAO implements EventsDAO {
    private Connection connection;

    public JdbcEventsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Events getEventByID(int eventsID) {
        Events event = null;
        String query = "SELECT * FROM Events WHERE EventID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, eventsID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                event = mapResultSetToEvent(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return event;
    }


    @Override
    public List<Events> getAllEvents() {
        List<Events> events = new ArrayList<>();
        String query = "SELECT * FROM Events";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Events event = mapResultSetToEvent(resultSet);
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public void addEvent(Events events) {
        String query = "INSERT INTO Events (EventName, VenueID, Date, StartTime, EndTime) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, events.getEventName());
            statement.setInt(2, events.getVenueID());
            statement.setDate(3, new java.sql.Date(events.getEventDate().getTime()));
            statement.setTime(4, new java.sql.Time(events.getStartTime().getTime()));
            statement.setTime(5, new java.sql.Time(events.getEndTime().getTime()));

            long affectedRows = statement.executeUpdate();// cuz of to date and time must be long data type

            if (affectedRows == 0) {
                throw new SQLException("Event creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    events.setEventID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Event creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEvent(Events events) {
        String query = "UPDATE Events SET EventName = ?, VenueID = ?, Date = ?, StartTime = ?, EndTime = ? WHERE EventID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, events.getEventName());
            statement.setInt(2, events.getVenueID());
            statement.setDate(3, new java.sql.Date(events.getEventDate().getTime()));
            statement.setTime(4, new java.sql.Time(events.getStartTime().getTime()));
            statement.setTime(5, new java.sql.Time(events.getEndTime().getTime()));
            statement.setInt(6, events.getEventID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEvent(int eventID) {
        String query = "DELETE FROM Events WHERE EventID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, eventID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Events mapResultSetToEvent(ResultSet resultSet) throws SQLException {
        int eventID = resultSet.getInt("EventID");
        String eventName = resultSet.getString("EventName");
        int venueID = resultSet.getInt("VenueID");
        Date date = resultSet.getDate("Date");
        Time startTime = resultSet.getTime("StartTime");
        Time endTime = resultSet.getTime("EndTime");

        return new Events(eventID, eventName, venueID, date, startTime, endTime);
    }
}
