package com.solvd.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Event {
    private int eventID;
    private String eventName;
    private LocalDateTime eventDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Venue venueID;


    public Event(int eventID, String eventName, Venue venueID, LocalDateTime eventDate, LocalDateTime startTime, LocalDateTime endTime) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.venueID = venueID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventDate = eventDate;
    }

    public Event() {

    }

    public Event(int eventID) {
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Venue getVenueID() {
        return venueID;
    }

    public void setVenueID(Venue venueID) {
        this.venueID = venueID;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", venueID=" + venueID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventID == event.eventID && Objects.equals(eventName, event.eventName) && Objects.equals(eventDate, event.eventDate) && Objects.equals(startTime, event.startTime) && Objects.equals(endTime, event.endTime) && Objects.equals(venueID, event.venueID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventID, eventName, eventDate, startTime, endTime, venueID);
    }


    public void setStartTime(int hour, int min, int sec) {
    }

    public void setEndTime(int hour, int min, int sec) {
    }
}
