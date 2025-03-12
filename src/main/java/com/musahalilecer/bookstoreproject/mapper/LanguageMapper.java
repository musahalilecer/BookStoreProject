package com.musahalilecer.bookstoreproject.mapper;

import com.musahalilecer.bookstoreproject.dto.LanguageDto;
import com.musahalilecer.bookstoreproject.model.Language;

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
