package com.example.demo.mappers;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.server.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    private final AuthorService authorService;

    public BookMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    public BookDto convertToDto(Book book) {
        return new BookDto(book.getId(),book.getTitle(),book.getAuthor().getId().toString());
    }

    public Book convertToEntity(BookDto bookDto) {
        Author author = authorService.getBookAuthor(bookDto.getAuthorId());
        return new Book(bookDto.getId(), bookDto.getTitle(), author);
    }
}
