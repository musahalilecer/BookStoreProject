package com.musahalilecer.bookstoreproject.total.mapper;

import com.musahalilecer.bookstoreproject.total.dto.GenreDto;
import com.musahalilecer.bookstoreproject.total.model.Genre;

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
