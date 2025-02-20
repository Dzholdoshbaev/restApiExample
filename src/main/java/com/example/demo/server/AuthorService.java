package com.example.demo.server;


import com.example.demo.dto.AuthorDto;
import com.example.demo.model.Author;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAllAuthors();

    AuthorDto createAuthor(AuthorDto authorDto);

    String deleteAuthor(String authorId);

    AuthorDto editAuthor(AuthorDto authorDto);

    AuthorDto convertToDto(Author author);

    Author convertToEntity(AuthorDto authorDto);

    Author getBookAuthor(String authorId);

    AuthorDto getAuthorById(String authorId);

    boolean checkBookAuthor(String authorId);
}
