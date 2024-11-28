package com.musahalilecer.book_store_project.service;

import com.musahalilecer.book_store_project.dto.GenreDto;
import com.musahalilecer.book_store_project.mapper.GenreMapper;
import com.musahalilecer.book_store_project.model.Genre;
import com.musahalilecer.book_store_project.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    // Get all genres as DTOs
    public List<GenreDto> getGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genres.stream()
                .map(GenreMapper::toGenreDto)
                .collect(Collectors.toList());
    }

    // Get a genre by ID as DTO
    public GenreDto getGenreById(Integer id) {
        return genreRepository.findById(id)
                .map(GenreMapper::toGenreDto)
                .orElse(null);
    }

    // Save a new genre from DTO
    public GenreDto saveGenre(GenreDto genreDto) {
        Genre genre = GenreMapper.toEntity(genreDto);
        Genre savedGenre = genreRepository.save(genre);
        return GenreMapper.toGenreDto(savedGenre);
    }

    // Update an existing genre
    public GenreDto updateGenre(int id, GenreDto genreDto) {
        return genreRepository.findById(id).map(existingGenre -> {
            existingGenre.setGenre(genreDto.getGenre());
            Genre updatedGenre = genreRepository.save(existingGenre);
            return GenreMapper.toGenreDto(updatedGenre);
        }).orElse(null);
    }

    // Delete a genre by ID
    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }
}
