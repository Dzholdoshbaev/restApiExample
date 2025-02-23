package com.example.demo.server.impl;

import com.example.demo.dto.AuthorDto;
import com.example.demo.exceptions.AuthorNotFoundException;
import com.example.demo.mappers.AuthorMapper;
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
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
       List<Author> authors = authorRepository.findAll();
        return authors.stream().map(authorMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = authorMapper.convertToEntity(authorDto);
        Author createdAuthor = authorRepository.save(author);
        return authorMapper.convertToDto(createdAuthor);
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
        Author author = authorMapper.convertToEntity(authorDto);
        Author updatedAuthor = authorRepository.save(author);
        return authorMapper.convertToDto(updatedAuthor);
    }

    @Override
    public Author getBookAuthor(String authorId) {
        return authorRepository.findById(UUID.fromString(authorId)).orElseThrow(() -> new AuthorNotFoundException("Author not found"));
    }

    @Override
    public AuthorDto getAuthorById(UUID authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author not found"));
        return authorMapper.convertToDto(author);
    }

    @Override
    public boolean checkBookAuthor(String authorId) {
        return authorRepository.existsById(UUID.fromString(authorId));
    }
}
