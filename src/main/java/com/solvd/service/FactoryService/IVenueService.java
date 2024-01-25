package com.solvd.service.FactoryService;

import com.solvd.model.Artist;

public interface IVenueService {
    Artist addArtist(Artist artist);

    Artist getArtistByID(int artistID);
}
