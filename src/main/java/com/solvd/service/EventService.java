package com.solvd.service;

import com.solvd.model.Event;
import com.solvd.persistence.dao.EventDAO;

import java.util.List;

public class EventService {
    private final EventDAO eventDAO;


    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }
    public void addEvent(Event event) {
        eventDAO.addEvent(event);
    }

    public void updateEvent(Event event) {
        eventDAO.updateEvent(event);
    }

    public void deleteEvent(int eventID) {
        eventDAO.deleteEvent(eventID);
    }

    public Event getEventByID(int eventID) {
        return eventDAO.getEventByID(eventID);
    }

    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

}
