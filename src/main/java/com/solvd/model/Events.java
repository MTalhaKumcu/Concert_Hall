package com.solvd.model;

import java.util.Objects;

public class Events {

    private int eventID;
    private String eventName;
    private String eventDate;
    private String startTime;
    private String endTime;
    private int venueID;

    public Events(int eventID, String eventName, String eventDate, String startTime, String endTime, int venueID) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venueID = venueID;
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

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getVenueID() {
        return venueID;
    }

    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return eventID == events.eventID && venueID == events.venueID && Objects.equals(eventName, events.eventName) && Objects.equals(eventDate, events.eventDate) && Objects.equals(startTime, events.startTime) && Objects.equals(endTime, events.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventID, eventName, eventDate, startTime, endTime, venueID);
    }

    @Override
    public String toString() {
        return "EventsDAO{" +
                "eventID=" + eventID +
                ", eventName='" + eventName + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", venueID=" + venueID +
                '}';
    }
}
