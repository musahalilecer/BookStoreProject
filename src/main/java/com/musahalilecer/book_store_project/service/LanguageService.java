package com.musahalilecer.book_store_project.service;

import com.musahalilecer.book_store_project.dto.LanguageDto;
import com.musahalilecer.book_store_project.mapper.LanguageMapper;
import com.musahalilecer.book_store_project.model.Language;
import com.musahalilecer.book_store_project.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    // Get all languages as DTOs
    public List<LanguageDto> getLanguages() {
        List<Language> languages = languageRepository.findAll();
        return languages.stream()
                .map(LanguageMapper::toDto)
                .collect(Collectors.toList());
    }

    // Get a language by ID as DTO
    public LanguageDto getLanguageById(int id) {
        return languageRepository.findById(id)
                .map(LanguageMapper::toDto)
                .orElse(null);
    }

    // Save a new language from DTO
    public LanguageDto saveLanguage(LanguageDto languageDto) {
        Language language = LanguageMapper.toEntity(languageDto);
        Language savedLanguage = languageRepository.save(language);
        return LanguageMapper.toDto(savedLanguage);
    }

    // Update an existing language
    public LanguageDto updateLanguage(int id, LanguageDto languageDto) {
        return languageRepository.findById(id).map(existingLanguage -> {
            existingLanguage.setLanguage(languageDto.getLanguage());
            Language updatedLanguage = languageRepository.save(existingLanguage);
            return LanguageMapper.toDto(updatedLanguage);
        }).orElse(null);
    }

    // Delete a language by ID
    public void deleteLanguage(int id) {
        languageRepository.deleteById(id);
    }
}
