package com.example.demo.server.impl;

import com.example.demo.dto.BookDto;
import com.example.demo.exceptions.AuthorNotFoundException;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.mappers.BookMapper;
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
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto editBook(BookDto bookDto) {
        if (!authorService.checkBookAuthor(bookDto.getAuthorId())){
            throw new AuthorNotFoundException("Author not found");
        }
        Book book = bookMapper.convertToEntity(bookDto);
        Book updatedBook = bookRepository.save(book);
        return bookMapper.convertToDto(updatedBook);
    }

    @Override
    public String deleteBook(UUID bookId) {
        if (!bookRepository.existsById(bookId)) {
                throw new BookNotFoundException("Book does not exist");
        }
        bookRepository.deleteById(bookId);
        return "Book deleted";
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        if (!authorService.checkBookAuthor(bookDto.getAuthorId())){
            throw new AuthorNotFoundException("Author not found");
        }
        Book book = bookMapper.convertToEntity(bookDto);
        Book createdBook = bookRepository.save(book);
        return bookMapper.convertToDto(createdBook);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(bookMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(UUID bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book does not exist"));
        return bookMapper.convertToDto(book);
    }
}
