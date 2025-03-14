package com.musahalilecer.bookstoreproject.total.mapper;

import com.musahalilecer.bookstoreproject.total.dto.LanguageDto;
import com.musahalilecer.bookstoreproject.total.model.Language;

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
