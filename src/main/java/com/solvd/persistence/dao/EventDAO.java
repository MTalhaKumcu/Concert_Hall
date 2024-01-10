package com.solvd.persistence.dao;

import com.solvd.model.Events;

import java.util.List;

public interface EventDAO {

    Events getEventByID (int eventsID);
    List<Events> getAllEvents();
    void addEvent(Events events);
    void updateEvent(Events events);
    void deleteEvent(int eventID);
}
