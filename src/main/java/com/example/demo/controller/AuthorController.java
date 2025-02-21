package com.example.demo.controller;


import com.example.demo.dto.AuthorDto;
import com.example.demo.exceptions.AuthorNotFoundException;
import com.example.demo.server.AuthorService;
import com.example.demo.controller.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PostMapping()
    public ResponseEntity<AuthorDto> create(@RequestBody AuthorDto authorDto) {
        return ResponseEntity.ok(authorService.createAuthor(authorDto));
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<?> delete(@PathVariable String authorId) {
        try {
            return ResponseEntity.ok(authorService.deleteAuthor(authorId));
        }catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Invalid UUID format");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (AuthorNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<?> getAuthor(@PathVariable String authorId) {
        try {
            return ResponseEntity.ok(authorService.getAuthorById(authorId));
        }catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Invalid UUID format");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (AuthorNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PutMapping()
    public ResponseEntity<?> edit(@RequestBody  AuthorDto authorDto) {
        try {
            return ResponseEntity.ok(authorService.editAuthor(authorDto));
        }catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Invalid UUID format");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (AuthorNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
