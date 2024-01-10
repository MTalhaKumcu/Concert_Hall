package com.solvd;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {


// ArtistService oluşturulur
        ArtistService artistService = new ArtistService();

        // Yeni bir sanatçı oluşturulur
        Artist newArtist = new Artist();
        newArtist.setArtistName("John Doe");
        newArtist.setBirthDate(java.sql.Date.valueOf("1990-01-01"));
        newArtist.setCountry("USA");

        // Sanatçı eklenir
        artistService.addArtist(newArtist);

        // Tüm sanatçılar listelenir
        System.out.println("All Artists:");
        artistService.getAllArtists().forEach(artist -> System.out.println(artist));

        // Sanatçı güncellenir
        newArtist.setCountry("Canada");
        artistService.updateArtist(newArtist);

        // Güncellenmiş sanatçıyı tekrar listeler
        System.out.println("\nUpdated Artist:");
        artistService.getAllArtists().forEach(artist -> System.out.println(artist));

        // Belirli bir sanatçıyı siler
        artistService.deleteArtist(newArtist.getArtistID());

        // Sanatçı silindikten sonra tüm sanatçıları tekrar listeler
        System.out.println("\nAll Artists After Deletion:");
        artistService.getAllArtists().forEach(artist -> System.out.println(artist));
    }
    }

}
