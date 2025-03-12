package com.musahalilecer.bookstoreproject.repository;

import com.musahalilecer.bookstoreproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
/*
    @Query("SELECT b FROM Book b " +
            "LEFT JOIN FETCH b.author " +
            "LEFT JOIN FETCH b.language " +
            "LEFT JOIN FETCH b.genres " +
            "LEFT JOIN FETCH b.customers " +
            "WHERE b.id = :id")
    Optional<Book> findBookById(@Param("id") Long id);

    @Query("SELECT DISTINCT b FROM Book b " +
            "LEFT JOIN FETCH b.author " +
            "LEFT JOIN FETCH b.language " +
            "LEFT JOIN FETCH b.genres " +
            "LEFT JOIN FETCH b.customers")
    List<Book> findAllWithDetails();

 */

    List<Book> findByAuthorId(Integer authorId);
    List<Book> findByLanguageId(Integer languageId);
    List<Book> findByGenresId(Integer genreId);

}
