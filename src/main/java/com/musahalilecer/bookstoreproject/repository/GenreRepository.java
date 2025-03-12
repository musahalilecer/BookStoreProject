package com.musahalilecer.bookstoreproject.repository;

import com.musahalilecer.bookstoreproject.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
