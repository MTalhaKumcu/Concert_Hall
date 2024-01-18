package com.solvd.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Artist {
    @XmlElement
    private int artistID;
    @XmlElement
    private String artistName;
    @XmlElement
    private String artistSurame;
    @XmlElement
    private Date birthDate;
    @XmlElement
    private String country;

    private Genre genreID;


    public Artist(int artistID, String artistName, String artistSurame, Date birthDate, String country) {
        this.artistID = artistID;
        this.artistName = artistName;
        this.artistSurame = artistSurame;
        this.birthDate = birthDate;
        this.country = country;
    }

    public Artist() {

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Genre getGenreID() {
        return genreID;
    }

    public void setGenreID(Genre genreID) {
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
        Artist artist = (Artist) o;
        return artistID == artist.artistID && Objects.equals(artistName, artist.artistName) && Objects.equals(artistSurame, artist.artistSurame) && Objects.equals(birthDate, artist.birthDate) && Objects.equals(country, artist.country) && Objects.equals(genreID, artist.genreID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistID, artistName, artistSurame, birthDate, country, genreID);
    }
}
