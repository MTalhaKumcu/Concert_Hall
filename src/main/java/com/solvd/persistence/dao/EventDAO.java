package com.solvd.persistence.dao;

import com.solvd.model.Event;

import java.util.List;

public interface EventDAO {

    Event getEventByID (int eventsID);
    List<Event> getAllEvents();
    void addEvent(Event event);
    void updateEvent(Event event);
    void deleteEvent(int eventID);
}
