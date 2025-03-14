package com.musahalilecer.bookstoreproject.total.repository;

import com.musahalilecer.bookstoreproject.total.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findByfirstName(String firstName);
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
