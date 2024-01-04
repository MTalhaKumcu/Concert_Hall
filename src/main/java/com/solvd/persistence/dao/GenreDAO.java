package com.solvd.persistence.dao;

import com.solvd.model.Genres;

import java.util.List;

public interface GenreDAO {
    Genres getGenreByID(int genreID);
    List<Genres> getAllGenres();
    void addGenre(Genres genres);
    void updateGenre(Genres genres);
    void deleteGenre(int genreID);
}
