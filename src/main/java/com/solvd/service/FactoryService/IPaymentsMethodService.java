package com.solvd.service.FactoryService;

import com.solvd.model.Artist;

public interface IPaymentsMethodService {
    Artist addArtist(Artist artist);

    Artist getArtistByID(int artistID);
}
