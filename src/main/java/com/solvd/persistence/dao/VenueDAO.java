package com.solvd.persistence.dao;

import com.solvd.model.Venue;

import java.util.List;

public interface VenueDAO {


    Venue getVenuesByID(int venuesID);

    List<Venue>getAllTickets();

    void addVenues(Venue venue);

    void updateVenues(Venue venue);

    void deleteVenues(int venuesID);

}
