package com.musahalilecer.bookstoreproject.repository;

import com.musahalilecer.bookstoreproject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    /*
    @Query("SELECT a FROM Author a " +
            "LEFT JOIN FETCH a.books " +
            "WHERE a.id = :id")
    Optional<Author> findAuthorWithBooks(@Param("id") Long id);

    @Query("SELECT DISTINCT a FROM Author a " +
            "LEFT JOIN FETCH a.books")
    List<Author> findAllWithBooks();

     */

}
