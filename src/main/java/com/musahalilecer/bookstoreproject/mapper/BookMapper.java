package com.musahalilecer.bookstoreproject.mapper;

import com.musahalilecer.bookstoreproject.dto.BookDto;
import com.musahalilecer.bookstoreproject.model.*;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "language.id", target = "languageId")
    @Mapping(source = "genres", target = "genreIds", qualifiedByName = "genresToIds")
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
                .collect(java.util.stream.Collectors.toSet());
    }

    @Named("customersToIds")
    default Set<Long> customersToIds(Set<Customer> customers) {
        if (customers == null) return null;
        return customers.stream()
                .map(Customer::getId)
                .collect(java.util.stream.Collectors.toSet());
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
                .collect(java.util.stream.Collectors.toSet());
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
                .collect(java.util.stream.Collectors.toSet());
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromDto(BookDto dto, @MappingTarget Book entity);
}

/*

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "language.id", target = "languageId")
    @Mapping(source = "genres", target = "genreIds", qualifiedByName = "genresToIds")
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
                .collect(java.util.stream.Collectors.toSet());
    }

    @Named("customersToIds")
    default Set<Long> customersToIds(Set<Customer> customers) {
        if (customers == null) return null;
        return customers.stream()
                .map(Customer::getId)
                .collect(java.util.stream.Collectors.toSet());
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
                .collect(java.util.stream.Collectors.toSet());
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
                .collect(java.util.stream.Collectors.toSet());
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromDto(BookDto dto, @MappingTarget Book entity);
}

 */
