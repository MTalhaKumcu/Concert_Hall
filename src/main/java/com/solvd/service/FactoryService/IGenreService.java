package com.solvd.service.FactoryService;

import com.solvd.model.Genre;

public interface IGenreService {
    Genre createGenre(Genre genre);

    Genre getGenreByID(int genreID);
}
