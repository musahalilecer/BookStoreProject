package com.musahalilecer.bookstoreproject.controller;

import com.musahalilecer.bookstoreproject.dto.AuthorDto;
import com.musahalilecer.bookstoreproject.model.Author;
import com.musahalilecer.bookstoreproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@RequestParam int id) {
        try{
            AuthorDto authorDto = authorService.getAuthorById(id);
            return ResponseEntity.ok(authorDto);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        try {
            AuthorDto newAuthorDto = authorService.createAuthor(authorDto);
            return ResponseEntity.ok(newAuthorDto);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable int id, @RequestBody AuthorDto authorDto) {
        try {
            AuthorDto updatedAuthorDto = authorService.updateAuthor(id, authorDto);
            return ResponseEntity.ok(updatedAuthorDto);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorDto> deleteAuthor(@PathVariable int id) {
        try {
            authorService.deleteAuthor(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
