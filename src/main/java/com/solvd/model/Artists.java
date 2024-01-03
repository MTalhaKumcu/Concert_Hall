package com.solvd.model;

import java.util.Objects;

public class Artists {
    private int artistID ;
    private String artistName;
    private String artistSurame;
    private String birthDate ;
    private String country;
    private int genreID ;

    public Artists(int artistID, String artistName, String artistSurame, String birthDate, String country, int genreID) {
        this.artistID = artistID;
        this.artistName = artistName;
        this.artistSurame = artistSurame;
        this.birthDate = birthDate;
        this.country = country;
        this.genreID = genreID;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistSurame() {
        return artistSurame;
    }

    public void setArtistSurame(String artistSurame) {
        this.artistSurame = artistSurame;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    @Override
    public String toString() {
        return "ArtistsDAO{" +
                "artistID=" + artistID +
                ", artistName='" + artistName + '\'' +
                ", artistSurame='" + artistSurame + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", country='" + country + '\'' +
                ", genreID=" + genreID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artists that = (Artists) o;
        return artistID == that.artistID && genreID == that.genreID && Objects.equals(artistName, that.artistName) && Objects.equals(artistSurame, that.artistSurame) && Objects.equals(birthDate, that.birthDate) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistID, artistName, artistSurame, birthDate, country, genreID);
    }
}
