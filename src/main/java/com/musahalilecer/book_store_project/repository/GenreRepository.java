package com.musahalilecer.book_store_project.repository;

import com.musahalilecer.book_store_project.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
