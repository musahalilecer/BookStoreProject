package com.musahalilecer.bookstoreproject.total.mapper;

import com.musahalilecer.bookstoreproject.total.dto.BookDto;
import com.musahalilecer.bookstoreproject.total.model.Author;
import com.musahalilecer.bookstoreproject.total.model.Book;
import com.musahalilecer.bookstoreproject.total.model.Genre;
import com.musahalilecer.bookstoreproject.total.model.Language;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Mapping(source = "author.firstName", target = "authorName")
    @Mapping(source = "language.language", target = "language")
    @Mapping(source = "genres", target = "genres", qualifiedByName = "genresToString")
    BookDto toDto(Book entity);

    @Mapping(target = "author", source = "authorName", qualifiedByName = "authorNameToAuthor")
    @Mapping(target = "language", source = "language", qualifiedByName = "languageNameToLanguage")
    @Mapping(target = "genres", source = "genres", qualifiedByName = "stringToGenres")
    Book toEntity(BookDto dto);

    @Named("genresToString")
    default String genresToString(Set<Genre> genres) {
        if (genres == null || genres.isEmpty()) return null;
        return genres.stream().map(Genre::getGenre).collect(Collectors.joining(","));
    }

    @Named("stringToGenres")
    default Set<Genre> stringToGenres(String genreNames) {
        if (genreNames == null || genreNames.isEmpty()) return null;
        return Set.of(genreNames.split(",")).stream()
                .map(name -> new Genre(name.trim()))
                .collect(Collectors.toSet());
    }

    @Named("authorNameToAuthor")
    default Author authorNameToAuthor(String name) {
        if (name == null || name.isEmpty()) return null;
        return new Author(name);
    }

    @Named("languageNameToLanguage")
    default Language languageNameToLanguage(String name) {
        if (name == null || name.isEmpty()) return null;
        return new Language(name);
    }
}
