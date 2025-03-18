package com.musahalilecer.bookstoreproject.total.service;

import com.musahalilecer.bookstoreproject.total.dto.BookDto;
import com.musahalilecer.bookstoreproject.total.mapper.BookMapper;
import com.musahalilecer.bookstoreproject.total.model.*;
import com.musahalilecer.bookstoreproject.total.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final LanguageRepository languageRepository;
    private final GenreRepository genreRepository;
    private final CustomerRepository customerRepository;
    private final BookMapper bookMapper;

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(null);
    }

    @Transactional
    public BookDto createBook(BookDto bookDto) {

        Optional<Author> author = authorRepository.findById(bookDto.getAuthorId());
        Optional<Language> language = languageRepository.findById(bookDto.getLanguageId());




        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(author.isEmpty() ? null : author.get());
        book.setLanguage(language.isEmpty() ? null : language.get());
    //    book.setGenres((Set<Genre>) genre);
        book.setPrice(bookDto.getPrice());
        book.setPage(bookDto.getPage());
        book.setImage(bookDto.getImage());

        return bookMapper.toDto(bookRepository.save(book));
        //    return bookRepository.save(book);
        // **********************
        // Convert DTO to entity
        /*
        Book book = bookMapper.toEntity(bookDto);

        // Set relationships
        setRelationships(book, bookDto);

        // Save and return
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);

         */
    }

    @Transactional
    public BookDto updateBook(Long id, BookDto bookDto) {

        Optional<Book> existingBook = bookRepository.findById(id);

        // Update simple fields using mapper
    //    bookMapper.updateBookFromDto(bookDto, existingBook);

        // Update relationships
    //    setRelationships(existingBook, bookDto);



        Book updatedBook = bookRepository.save(existingBook.isEmpty() ? null : existingBook.get());
        return bookMapper.toDto(updatedBook);
    }

    @Transactional
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(null);

        // Clear relationships before deleting
        book.setAuthor(null);
        book.setLanguage(null);
        book.getGenres().clear();
        book.getCustomers().clear();

        bookRepository.delete(book);
    }

    private void setRelationships(Book book, BookDto bookDto) {
        // Set Author
        if (bookDto.getAuthorId() != null) {
            Author author = authorRepository.findById(bookDto.getAuthorId())
                    .orElseThrow(null);
            book.setAuthor(author);
        }

        // Set Language
        if (bookDto.getLanguageId() != null) {
            Language language = languageRepository.findById(bookDto.getLanguageId())
                    .orElseThrow(null);
            book.setLanguage(language);
        }

        // Set Genres
        if (bookDto.getGenreIds() != null && !bookDto.getGenreIds().isEmpty()) {
            Set<Genre> genres = bookDto.getGenreIds().stream()
                    .map(genreId -> genreRepository.findById(genreId)
                            .orElseThrow(null))
                    .collect(Collectors.toSet());
            book.setGenres(genres);
        } else {
            book.setGenres(new HashSet<>());
        }

        // Set Customers
        if (bookDto.getCustomerIds() != null && !bookDto.getCustomerIds().isEmpty()) {
            Set<Customer> customers = bookDto.getCustomerIds().stream()
                    .map(customerId -> customerRepository.findById(customerId)
                            .orElseThrow(null))
                    .collect(Collectors.toSet());
            book.setCustomers(customers);
        } else {
            book.setCustomers(new HashSet<>());
        }
    }

    // Additional useful methods

    public List<BookDto> getBooksByAuthor(Integer authorId) {
        return bookRepository.findByAuthorId(authorId)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> getBooksByLanguage(Integer languageId) {
        return bookRepository.findByLanguageId(languageId)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> getBooksByGenre(Integer genreId) {
        return bookRepository.findByGenresId(genreId)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookDto addCustomerToBook(Long bookId, Long customerId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(null);

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(null);

        book.getCustomers().add(customer);
        Book updatedBook = bookRepository.save(book);
        return bookMapper.toDto(updatedBook);
    }

    @Transactional
    public BookDto removeCustomerFromBook(Long bookId, Long customerId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(null);

        book.setCustomers(book.getCustomers().stream()
                .filter(customer -> !customer.getId().equals(customerId))
                .collect(Collectors.toSet()));

        Book updatedBook = bookRepository.save(book);
        return bookMapper.toDto(updatedBook);
    }
}
