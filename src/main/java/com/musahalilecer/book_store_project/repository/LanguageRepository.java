package com.musahalilecer.book_store_project.repository;

import com.musahalilecer.book_store_project.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
