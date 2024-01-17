package com.solvd.model;

import java.util.Objects;

public class Genre {

    private int genreID;
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
    public void setGenreName(String countryMusic){
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
