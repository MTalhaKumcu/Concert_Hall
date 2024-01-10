package com.solvd.service;

import com.solvd.model.Venues;
import com.solvd.persistence.dao.VenueDAO;

import java.util.List;

public class VenueService {
    private final VenueDAO venueDAO;

    public VenueService(VenueDAO venueDAO) {
        this.venueDAO = venueDAO;
    }

    public Venues getVenuesByID(int venuesID) {
        return venueDAO.getVenuesByID(venuesID);
    }

    public List<Venues> getAllTickets() {
        return venueDAO.getAllTickets();
    }

    public void addVenues(Venues venues) {
        venueDAO.addVenues(venues);
    }

    public void updateVenues(Venues venues) {
        venueDAO.updateVenues(venues);
    }

    public void deleteVenues(int venuesID) {
        venueDAO.deleteVenues(venuesID);
    }
}
