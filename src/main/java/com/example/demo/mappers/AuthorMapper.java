package com.example.demo.mappers;

import com.example.demo.dto.AuthorDto;
import com.example.demo.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorMapper() {
    }

    public AuthorDto convertToDto(Author author) {
        return new AuthorDto(author.getId(),author.getName(),author.getSurname(),author.getBirthDate());
    }

    public Author convertToEntity(AuthorDto authorDto) {
        return new Author(authorDto.getId(),authorDto.getName(),authorDto.getSurname(),authorDto.getBirthDate());
    }
}
