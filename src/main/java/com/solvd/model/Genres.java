package com.solvd.model;

import java.util.Objects;

public class Genres {

    private int genreID;
    private String genreName;

    public Genres(int genreID , String genreName){
        this.genreID = genreID;
        this.genreName = genreName;
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
    public void setGenreName(){
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genres genres = (Genres) o;
        return genreID == genres.genreID && Objects.equals(genreName, genres.genreName);
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
