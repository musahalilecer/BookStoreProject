package com.musahalilecer.bookstoreproject.repository;

import com.musahalilecer.bookstoreproject.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Optional<Language> findByName(String name);
}
