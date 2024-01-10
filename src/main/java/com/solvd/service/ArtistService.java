package com.solvd.service;

import com.solvd.model.Artists;
import com.solvd.persistence.dao.ArtistsDAO;

import java.util.List;

public class ArtistService {

    private final ArtistsDAO artistDAO;

    public ArtistService(ArtistsDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

    public void addArtist(Artists artist) {
        artistDAO.addArtist(artist);
    }

    public void updateArtist(Artists artist) {
        artistDAO.updateArtist(artist);
    }

    public void deleteArtist(int artistID) {
        artistDAO.deleteArtist(artistID);
    }

    public Artists getArtistByID(int artistID) {
        return artistDAO.getArtistsByID(artistID);
    }

    public List<Artists> getAllArtists() {
        return artistDAO.getAllArtists();
    }
}
