package com.musahalilecer.bookstoreproject.controller;

import com.musahalilecer.bookstoreproject.dto.LanguageDto;
import com.musahalilecer.bookstoreproject.repository.LanguageRepository;
import com.musahalilecer.bookstoreproject.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getAllLanguages() {
        List<LanguageDto> languages = languageService.getLanguages();
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageDto> getLanguageById(@PathVariable int id) {
        LanguageDto language = languageService.getLanguageById(id);
        if (language != null) {
            return ResponseEntity.ok(language);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<LanguageDto> createLanguage(@RequestBody LanguageDto language) {
        LanguageDto newLanguage = languageService.saveLanguage(language);
        return ResponseEntity.ok(newLanguage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageDto> updateLanguage(@PathVariable int id, @RequestBody LanguageDto language) {
        LanguageDto updatedLanguage = languageService.updateLanguage(id, language);
        if (updatedLanguage != null) {
            return ResponseEntity.ok(updatedLanguage);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<LanguageDto> deleteLanguage(@PathVariable int id) {
        languageService.deleteLanguage(id);
        return ResponseEntity.ok().build();
    }
}

