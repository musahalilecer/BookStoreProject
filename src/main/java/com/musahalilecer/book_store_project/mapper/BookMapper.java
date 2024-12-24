package com.musahalilecer.book_store_project.mapper;

import com.musahalilecer.book_store_project.dto.BookDto;
import com.musahalilecer.book_store_project.model.*;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "language.id", target = "languageId")
    BookDto toDto(Book entity);

    @AfterMapping
    default void enrichDto(@MappingTarget BookDto dto, Book entity) {
        if (entity.getAuthor() != null) {
            dto.setFirstName(Set.of(entity.getAuthor().getFirstName()));
            dto.setLastName(Set.of(entity.getAuthor().getLastName()));
        }
        if (entity.getGenres() != null) {
            dto.setGenreNames(entity.getGenres().stream().map(Genre::getGenre).collect(Collectors.toSet()));
        }
    }
}

/*
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.firstName", target = "firstName", qualifiedByName = "authorFirstName")
    @Mapping(source = "author.lastName", target = "lastName", qualifiedByName = "authorLastName")
    @Mapping(source = "language.id", target = "languageId")
    @Mapping(source = "language.language", target = "languageName")
    @Mapping(source = "genres", target = "genreIds", qualifiedByName = "genresToIds")
    @Mapping(source = "genres", target = "genreNames", qualifiedByName = "genresToNames")
    @Mapping(source = "customers", target = "customerIds", qualifiedByName = "customersToIds")
    BookDto toDto(Book entity);


    @Mapping(target = "author", source = "authorId", qualifiedByName = "authorIdToAuthor")
    @Mapping(target = "language", source = "languageId", qualifiedByName = "languageIdToLanguage")
    @Mapping(target = "genres", source = "genreIds", qualifiedByName = "genreIdsToGenres")
    @Mapping(target = "customers", source = "customerIds", qualifiedByName = "customerIdsToCustomers")
    Book toEntity(BookDto dto);

    @Named("genresToIds")
    default Set<Integer> genresToIds(Set<Genre> genres) {
        if (genres == null) return null;
        return genres.stream()
                .map(Genre::getId)
                .collect(Collectors.toSet());
    }

    @Named("genresToNames")
    default Set<String> genresToNames(Set<Genre> genres) {
        if (genres == null) return null;
        return genres.stream()
                .map(Genre::getGenre)
                .collect(Collectors.toSet());
    }

    @Named("customersToIds")
    default Set<Long> customersToIds(Set<Customer> customers) {
        if (customers == null) return null;
        return customers.stream()
                .map(Customer::getId)
                .collect(Collectors.toSet());
    }

    @Named("authorIdToAuthor")
    default Author authorIdToAuthor(Integer id) {
        if (id == null) return null;
        Author author = new Author();
        author.setId(id);
        return author;
    }

    @Named("languageIdToLanguage")
    default Language languageIdToLanguage(Integer id) {
        if (id == null) return null;
        Language language = new Language();
        language.setId(id);
        return language;
    }

    @Named("genreIdsToGenres")
    default Set<Genre> genreIdsToGenres(Set<Integer> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> {
                    Genre genre = new Genre();
                    genre.setId(id);
                    return genre;
                })
                .collect(Collectors.toSet());
    }

    @Named("customerIdsToCustomers")
    default Set<Customer> customerIdsToCustomers(Set<Long> ids) {
        if (ids == null) return null;
        return ids.stream()
                .map(id -> {
                    Customer customer = new Customer();
                    customer.setId(id);
                    return customer;
                })
                .collect(Collectors.toSet());
    }

    @Named("authorFirstName")
    default String authorFirstName(Author author) {
        if (author == null) return null;
        return author.getFirstName();
    }

    @Named("authorLastName")
    default String authorLastName(Author author) {
        if (author == null) return null;
        return author.getLastName();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromDto(BookDto dto, @MappingTarget Book entity);
}

 */
