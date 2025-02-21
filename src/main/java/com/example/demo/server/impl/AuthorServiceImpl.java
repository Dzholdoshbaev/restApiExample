package com.example.demo.server.impl;

import com.example.demo.dto.AuthorDto;
import com.example.demo.exceptions.AuthorNotFoundException;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.server.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
       List<Author> authors = authorRepository.findAll();
        return authors.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = convertToEntity(authorDto);
        Author createdAuthor = authorRepository.save(author);
        return convertToDto(createdAuthor);
    }

    @Override
    public String deleteAuthor(UUID authorId) {
        if (!authorRepository.existsById(authorId)) {
                throw new AuthorNotFoundException("Author does not exist");
        }
        authorRepository.deleteById(authorId);
        return "Author deleted";
    }

    @Override
    public AuthorDto editAuthor(AuthorDto authorDto) {
        if (!authorRepository.existsById(authorDto.getId())) {
            throw new AuthorNotFoundException("Author does not exist");
        }
        Author author = convertToEntity(authorDto);
        Author updatedAuthor = authorRepository.save(author);
        return convertToDto(updatedAuthor);
    }

    @Override
    public AuthorDto convertToDto(Author author) {
        return new AuthorDto(author.getId(),author.getName(),author.getSurname(),author.getBirthDate());
    }

    @Override
    public Author convertToEntity(AuthorDto authorDto) {
        return new Author(authorDto.getId(),authorDto.getName(),authorDto.getSurname(),authorDto.getBirthDate());
    }


    @Override
    public Author getBookAuthor(String authorId) {
        return authorRepository.findById(UUID.fromString(authorId)).orElseThrow(() -> new AuthorNotFoundException("Author not found"));
    }

    @Override
    public AuthorDto getAuthorById(UUID authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author not found"));
        return convertToDto(author);
    }

    @Override
    public boolean checkBookAuthor(String authorId) {
        return authorRepository.existsById(UUID.fromString(authorId));
    }
}
