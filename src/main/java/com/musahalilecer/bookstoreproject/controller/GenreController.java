package com.musahalilecer.bookstoreproject.controller;

import com.musahalilecer.bookstoreproject.dto.GenreDto;
import com.musahalilecer.bookstoreproject.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreDto>> getAllGenres() {
        List<GenreDto> genres = genreService.getGenres();
        return ResponseEntity.ok(genres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDto> getGenreById(@PathVariable int id) {
        GenreDto genre = genreService.getGenreById(id);
        if(genre != null) {
            return ResponseEntity.ok(genre);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<GenreDto> createGenre(@RequestBody GenreDto genreDto) {
        GenreDto newGenre = genreService.saveGenre(genreDto);
        return ResponseEntity.ok(newGenre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDto> updateGenre(@PathVariable int id, @RequestBody GenreDto genreDto) {
        GenreDto updatedGenre = genreService.updateGenre(id, genreDto);
        if(updatedGenre != null) {
            return ResponseEntity.ok(updatedGenre);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenreDto> deleteGenre(@PathVariable int id) {
        genreService.deleteGenre(id);
        return ResponseEntity.ok().build();
    }
}
