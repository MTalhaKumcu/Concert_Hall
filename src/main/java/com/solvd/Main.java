package com.solvd;

import com.solvd.model.Artist;
import com.solvd.service.ArtistService;
import org.apache.logging.log4j.LogManager;

import java.sql.*;
import java.util.List;


public class Main {
    private static final Logger LOGGER = new Logger();

    public static void main(String[] args) throws SQLException {


        try {
            // Sanatçı eklenmesi
            ArtistService artistService = new ArtistService();
            Artist newArtist = new Artist(11, "New artist",
                    "new","1997-1-1","turkey",11);
            artistService.addArtist(newArtist);
            LOGGER.log("New artist added: " + newArtist);

            // Tüm sanatçıların listelenmesi
            List<Artist> allArtists = artistService.getAllArtists();
            LOGGER.log("All artists:");
            for (Artist artist : allArtists) {
                LOGGER.log(artist.toString());
            }

            // Bir sanatçının güncellenmesi
            Artist artistToUpdate = allArtists.get(0);
            artistToUpdate.setCountry("Updated Country");
            artistService.updateArtist(artistToUpdate);
            LOGGER.log("Updated artist: " + artistToUpdate);

        } catch (Exception e) {
            LOGGER.log("An error occurred: " + e.getMessage());
        }
    }

    private static class Logger {
        void log(String message) {
            System.out.println(message);
        }
    }
}

