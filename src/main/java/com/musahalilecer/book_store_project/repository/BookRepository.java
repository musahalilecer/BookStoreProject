package com.musahalilecer.book_store_project.repository;

import com.musahalilecer.book_store_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Integer authorId);
    List<Book> findByLanguageId(Integer languageId);
    List<Book> findByGenresId(Integer genreId);

    List<Book> findByTitle(String title);

}
