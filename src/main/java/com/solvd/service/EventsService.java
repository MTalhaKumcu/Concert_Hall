package com.solvd.service;

import com.solvd.model.Events;
import com.solvd.persistence.dao.EventsDAO;

import java.util.List;

public class EventsService {
    private final EventsDAO eventDAO;


    public EventsService(EventsDAO eventDAO) {
        this.eventDAO = eventDAO;
    }
    public void addEvent(Events event) {
        eventDAO.addEvent(event);
    }

    public void updateEvent(Events event) {
        eventDAO.updateEvent(event);
    }

    public void deleteEvent(int eventID) {
        eventDAO.deleteEvent(eventID);
    }

    public Events getEventByID(int eventID) {
        return eventDAO.getEventByID(eventID);
    }

    public List<Events> getAllEvents() {
        return eventDAO.getAllEvents();
    }

}
