package com.musahalilecer.book_store_project.mapper;

import com.musahalilecer.book_store_project.dto.LanguageDto;
import com.musahalilecer.book_store_project.model.Language;

public class LanguageMapper {
    public static LanguageDto toDto(Language language) {
        return new LanguageDto(
                language.getId(),
                language.getLanguage()
        );
    }

    public static Language toEntity(LanguageDto languageDto) {
        return new Language(
                languageDto.getId(),
                languageDto.getLanguage()
        );
    }
}
