package com.solvd.service;

import com.solvd.model.Genres;
import com.solvd.persistence.dao.GenreDAO;

import java.util.List;

public class GenreService {
    private final GenreDAO genreDAO;

    public GenreService(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    public Genres getGenreByID(int genreID) {
        return genreDAO.getGenreByID(genreID);
    }

    public List<Genres> getAllGenres() {
        return genreDAO.getAllGenres();
    }

    public void addGenre(Genres genres) {
        genreDAO.addGenre(genres);
    }

    public void updateGenre(Genres genres) {
        genreDAO.updateGenre(genres);
    }

    public void deleteGenre(int genreID) {
        genreDAO.deleteGenre(genreID);
    }
}
