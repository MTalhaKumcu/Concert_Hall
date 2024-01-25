package com.solvd.service.FactoryService;

import com.solvd.model.Venue;

public interface IVenueService {
    Venue createVenue(Venue venue);

    Venue getVenueByID(int venueID);
}
