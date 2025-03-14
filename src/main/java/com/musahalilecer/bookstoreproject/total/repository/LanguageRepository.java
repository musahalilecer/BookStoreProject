package com.musahalilecer.bookstoreproject.total.repository;

import com.musahalilecer.bookstoreproject.total.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Optional<Language> findByLanguage(String name);
}
