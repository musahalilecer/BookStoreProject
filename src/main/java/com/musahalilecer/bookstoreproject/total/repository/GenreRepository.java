package com.musahalilecer.bookstoreproject.total.repository;

import com.musahalilecer.bookstoreproject.total.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByGenre(String genre);
}
