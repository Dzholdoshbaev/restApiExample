package com.example.demo.server;


import com.example.demo.dto.AuthorDto;
import com.example.demo.model.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    List<AuthorDto> getAllAuthors();

    AuthorDto createAuthor(AuthorDto authorDto);

    String deleteAuthor(UUID authorId);

    AuthorDto editAuthor(AuthorDto authorDto);

    AuthorDto convertToDto(Author author);

    Author convertToEntity(AuthorDto authorDto);

    Author getBookAuthor(String authorId);

    AuthorDto getAuthorById(UUID authorId);

    boolean checkBookAuthor(String authorId);
}
