package com.solvd.service.JdbcDaoService;

import com.solvd.model.Artist;
import com.solvd.persistence.dao.ArtistDAO;

import java.util.List;

public class ArtistService {

    private ArtistDAO artistDAO;

    public ArtistService() {
        this.artistDAO = artistDAO;
    }

    public void addArtist(Artist artist) {
        artistDAO.addArtist(artist);
    }

    public void updateArtist(Artist artist) {
        artistDAO.updateArtist(artist);
    }

    public void deleteArtist(int artistID) {
        artistDAO.deleteArtist(artistID);
    }

    public Artist getArtistByID(int artistID) {
        return artistDAO.getArtistsByID(artistID);
    }

    public List<Artist> getAllArtists() {
        return artistDAO.getAllArtists();
    }
}
