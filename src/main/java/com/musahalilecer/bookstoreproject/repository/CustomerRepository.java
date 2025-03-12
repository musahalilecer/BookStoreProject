package com.musahalilecer.bookstoreproject.repository;

import com.musahalilecer.bookstoreproject.model.Customer;
import com.musahalilecer.bookstoreproject.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /*
    @Query("SELECT l FROM Language l " +
            "LEFT JOIN FETCH l.books " +
            "WHERE l.id = :id")
    Optional<Language> findLanguageWithBooks(@Param("id") Long id);

    @Query("SELECT DISTINCT l FROM Language l " +
            "LEFT JOIN FETCH l.books")
    List<Language> findAllWithBooks();

     */

}
