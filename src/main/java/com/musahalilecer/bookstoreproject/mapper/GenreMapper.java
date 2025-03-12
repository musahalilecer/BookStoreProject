package com.musahalilecer.bookstoreproject.mapper;

import com.musahalilecer.bookstoreproject.dto.GenreDto;
import com.musahalilecer.bookstoreproject.model.Genre;

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
