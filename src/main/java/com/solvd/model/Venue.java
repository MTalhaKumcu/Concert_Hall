package com.solvd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "Venue")
@XmlAccessorType(XmlAccessType.FIELD)
public class Venue {
    @XmlElement
    private int venueID;
    @XmlElement
    private String venueName;
    @XmlElement
    private int capacity;
    @XmlElement
    private String location;

    public Venue(int venueID, String venueName, int capacity, String location) {
        this.venueID = venueID;
        this.venueName = venueName;
        this.capacity = capacity;
        this.location = location;
    }

    public Venue() {

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
        Venue venue = (Venue) o;
        return venueID == venue.venueID && capacity == venue.capacity && Objects.equals(venueName, venue.venueName) && Objects.equals(location, venue.location);
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
