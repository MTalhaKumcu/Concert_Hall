package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

@XmlRootElement(name = "Genre")
@XmlAccessorType(XmlAccessType.FIELD)
public class Genre {
    @XmlElement
    @JsonProperty("genreID")
    private int genreID;
    @XmlElement
    @JsonProperty("genreName")
    private String genreName;

    public Genre(int genreID , String genreName){
        this.genreID = genreID;
        this.genreName = genreName;
    }

    public Genre() {

    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getGenreName(){
        return  genreName;
    }
    public void setGenreName(String genreName){
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return genreID == genre.genreID && Objects.equals(genreName, genre.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreID, genreName);
    }

    @Override
    public String toString() {
        return "GenresDAO{" +
                "genreID=" + genreID +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
