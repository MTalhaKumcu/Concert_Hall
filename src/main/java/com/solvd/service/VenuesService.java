package com.solvd.service;

import com.solvd.model.Venues;
import com.solvd.persistence.dao.VenuesDAO;

import java.util.List;

public class VenuesService {
    private final VenuesDAO venuesDAO;

    public VenuesService(VenuesDAO venuesDAO) {
        this.venuesDAO = venuesDAO;
    }

    public Venues getVenuesByID(int venuesID) {
        return venuesDAO.getVenuesByID(venuesID);
    }

    public List<Venues> getAllTickets() {
        return venuesDAO.getAllTickets();
    }

    public void addVenues(Venues venues) {
        venuesDAO.addVenues(venues);
    }

    public void updateVenues(Venues venues) {
        venuesDAO.updateVenues(venues);
    }

    public void deleteVenues(int venuesID) {
        venuesDAO.deleteVenues(venuesID);
    }
}
