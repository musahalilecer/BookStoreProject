package com.musahalilecer.bookstoreproject.total.service;

import com.musahalilecer.bookstoreproject.total.dto.AuthorDto;
import com.musahalilecer.bookstoreproject.total.mapper.AuthorMapper;
import com.musahalilecer.bookstoreproject.total.model.Author;
import com.musahalilecer.bookstoreproject.total.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(AuthorMapper::toDTo).collect(Collectors.toList());
    }

    public AuthorDto getAuthorById(int id) {
        return authorRepository.findById(id)
                .map(AuthorMapper::toDTo)
                .orElse(null);
    }

    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = AuthorMapper.toEntity(authorDto);
        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.toDTo(savedAuthor);
    }

    public AuthorDto updateAuthor(int id, AuthorDto authorDto) {
        return authorRepository.findById(id).map(existingAuthor -> {
            existingAuthor.setFirstName(authorDto.getFirstName());
            existingAuthor.setLastName(authorDto.getLastName());
            existingAuthor.setImage(authorDto.getImage());
            Author updatedAuthor = authorRepository.save(existingAuthor);
            return AuthorMapper.toDTo(updatedAuthor);
        }).orElse(null);
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
