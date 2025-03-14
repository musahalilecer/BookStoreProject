package com.musahalilecer.bookstoreproject.total.repository;

import com.musahalilecer.bookstoreproject.total.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
