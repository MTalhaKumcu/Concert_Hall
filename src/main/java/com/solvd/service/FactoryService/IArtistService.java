package com.solvd.service.FactoryService;

import com.solvd.model.Artist;

public interface IArtistService {
    Artist createArtist(Artist artist);

    Artist getArtistByID(int artistID);
}
