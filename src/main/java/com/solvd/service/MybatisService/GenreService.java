package com.solvd.service.MybatisService;

import com.solvd.model.Genre;
import com.solvd.persistence.dao.GenreDAO;

import java.util.List;

public class GenreService {
    private final GenreDAO genreDAO;

    public GenreService(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    public Genre getGenreByID(int genreID) {
        return genreDAO.getGenreByID(genreID);
    }

    public List<Genre> getAllGenres() {
        return genreDAO.getAllGenres();
    }

    public void addGenre(Genre genre) {
        genreDAO.addGenre(genre);
    }

    public void updateGenre(Genre genre) {
        genreDAO.updateGenre(genre);
    }

    public void deleteGenre(int genreID) {
        genreDAO.deleteGenre(genreID);
    }
}
