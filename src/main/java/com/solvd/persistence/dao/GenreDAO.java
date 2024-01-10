package com.solvd.persistence.dao;

import com.solvd.model.Genre;

import java.util.List;

public interface GenreDAO {
    Genre getGenreByID(int genreID);
    List<Genre> getAllGenres();
    void addGenre(Genre genre);
    void updateGenre(Genre genre);
    void deleteGenre(int genreID);
}
