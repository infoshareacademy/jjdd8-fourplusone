package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.GenreJson;
import com.infoshareacademy.domain.entity.Genre;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class GenreMapper {

    public Genre mapApiRequestToEntity(GenreJson genreJson) {

        Genre genre = new Genre();
        genre.setName(genreJson.getName());
        return genre;
    }
}