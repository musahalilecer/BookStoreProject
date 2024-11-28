package com.musahalilecer.book_store_project.mapper;

import com.musahalilecer.book_store_project.dto.AuthorDto;
import com.musahalilecer.book_store_project.model.Author;

public class AuthorMapper {
    public static AuthorDto toDTo(Author author) {
        return new AuthorDto(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getImage()
        );
    }

    public static Author toEntity(AuthorDto authorDto) {
        return new Author(
                authorDto.getId(),
                authorDto.getFirstName(),
                authorDto.getLastName(),
                authorDto.getImage()
        );
    }
}
