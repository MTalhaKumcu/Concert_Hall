package com.solvd.persistence.dao;

import com.solvd.model.Artist;

import java.util.List;



public interface ArtistDAO {
    Artist getArtistsByID(int artistID);

    List<Artist> getAllArtists();

    void addArtist(Artist artist);

    void updateArtist(Artist artist);

    void deleteArtist(int artistID);

}
