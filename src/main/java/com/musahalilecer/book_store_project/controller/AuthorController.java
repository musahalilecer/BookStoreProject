package com.musahalilecer.book_store_project.controller;

import com.musahalilecer.book_store_project.dto.AuthorDto;
import com.musahalilecer.book_store_project.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public ResponseEntity<List<AuthorDto>> getAuthors(){
        List<AuthorDto> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Integer id){
        AuthorDto author = authorService.getAuthorById(id);
        if(author != null){
            return ResponseEntity.ok(author);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto author){
        AuthorDto newAuthor = authorService.createAuthor(author);
        return ResponseEntity.ok(newAuthor);
    }

    @PutMapping
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto author, @PathVariable Integer id){
        AuthorDto updatedAuthor = authorService.updateAuthor(id, author);
        if(updatedAuthor != null){
            return ResponseEntity.ok(updatedAuthor);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorDto> deleteAuthorById(@PathVariable Integer id){
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
