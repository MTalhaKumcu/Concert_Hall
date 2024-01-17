package com.solvd.service.MybatisService;

import com.solvd.model.Venue;
import com.solvd.persistence.dao.VenueDAO;

import java.util.List;

public class VenueService {
    private final VenueDAO venueDAO;

    public VenueService(VenueDAO venueDAO) {
        this.venueDAO = venueDAO;
    }

    public Venue getVenuesByID(int venuesID) {
        return venueDAO.getVenuesByID(venuesID);
    }

    public List<Venue> getAllTickets() {
        return venueDAO.getAllVenues();
    }

    public void addVenues(Venue venue) {
        venueDAO.addVenues(venue);
    }

    public void updateVenues(Venue venue) {
        venueDAO.updateVenues(venue);
    }

    public void deleteVenues(int venuesID) {
        venueDAO.deleteVenues(venuesID);
    }
}
