package com.solvd.model;

import java.util.Objects;

public class VenuesDAO {
    private int venueID;
    private String venueName;
    private int capacity;
    private String location;

    public VenuesDAO(int venueID, String venueName, int capacity, String location) {
        this.venueID = venueID;
        this.venueName = venueName;
        this.capacity = capacity;
        this.location = location;
    }

    public int getVenueID() {
        return venueID;
    }

    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VenuesDAO venuesDAO = (VenuesDAO) o;
        return venueID == venuesDAO.venueID && capacity == venuesDAO.capacity && Objects.equals(venueName, venuesDAO.venueName) && Objects.equals(location, venuesDAO.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venueID, venueName, capacity, location);
    }

    @Override
    public String toString() {
        return "VenuesDAO{" +
                "venueID=" + venueID +
                ", venueName='" + venueName + '\'' +
                ", capacity=" + capacity +
                ", location='" + location + '\'' +
                '}';
    }
}
