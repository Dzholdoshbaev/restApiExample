package com.example.demo.server.impl;


import com.example.demo.dto.BookDto;
import com.example.demo.exceptions.AuthorNotFoundException;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.server.AuthorService;
import com.example.demo.server.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public BookDto editBook(BookDto bookDto) {
        if (!authorService.checkBookAuthor(bookDto.getAuthorId())){
            throw new AuthorNotFoundException("Author not found");
        }
        Book book = convertToEntity(bookDto);
        Book updatedBook = bookRepository.save(book);
        return convertToDto(updatedBook);
    }

    @Override
    public String deleteBook(String bookId) {
        if (!bookRepository.existsById(UUID.fromString(bookId))) {
                throw new BookNotFoundException("Book does not exist");
        }
        bookRepository.deleteById(UUID.fromString(bookId));
        return "Book deleted";
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        if (!authorService.checkBookAuthor(bookDto.getAuthorId())){
            throw new AuthorNotFoundException("Author not found");
        }
        Book book = convertToEntity(bookDto);
        Book createdBook = bookRepository.save(book);
        return convertToDto(createdBook);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public BookDto convertToDto(Book book) {
        return new BookDto(book.getId(),book.getTitle(),book.getAuthor().getId().toString());
    }

    @Override
    public Book convertToEntity(BookDto bookDto) {
        Author author = authorService.getBookAuthor(bookDto.getAuthorId());
        return new Book(bookDto.getId(), bookDto.getTitle(), author);
    }

    @Override
    public BookDto getBookById(String bookId) {
        Book book = bookRepository.findById(UUID.fromString(bookId)).orElseThrow(() -> new BookNotFoundException("Book does not exist"));
        return convertToDto(book);
    }
}
