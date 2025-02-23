package com.example.demo.server;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import java.util.List;
import java.util.UUID;

public interface BookService {
    BookDto editBook(BookDto bookDto);

    String deleteBook(UUID bookId);

    BookDto createBook(BookDto bookDto);

    List<BookDto> getAllBooks();

    BookDto convertToDto(Book book);

    Book convertToEntity(BookDto bookDto);

    BookDto getBookById(UUID bookId);
}
