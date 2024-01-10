package com.solvd.persistence.dao;

import com.solvd.model.Artists;
import java.util.List;



public interface ArtistsDAO {
    Artists getArtistsByID(int artistID);

    List<Artists> getAllArtists();

    void addArtist(Artists artists);

    void updateArtist(Artists artists);

    void deleteArtist(int artistID);

}
