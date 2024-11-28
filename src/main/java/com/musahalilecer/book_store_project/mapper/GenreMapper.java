package com.musahalilecer.book_store_project.mapper;

import com.musahalilecer.book_store_project.dto.GenreDto;
import com.musahalilecer.book_store_project.model.Genre;

public class GenreMapper {
    public static GenreDto toGenreDto(Genre genre) {
        return new GenreDto(
                genre.getId(),
                genre.getGenre()
        );
    }

    public static Genre toEntity(GenreDto genreDto) {
        return new Genre(
                genreDto.getId(),
                genreDto.getGenre()
        );
    }
}
