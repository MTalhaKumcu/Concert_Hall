package com.solvd.persistence.dao;

import com.solvd.model.Venues;

import java.util.List;

public interface VenueDAO {


    Venues getVenuesByID(int venuesID);

    List<Venues>getAllTickets();

    void addVenues(Venues venues);

    void updateVenues(Venues venues);

    void deleteVenues(int venuesID);

}
