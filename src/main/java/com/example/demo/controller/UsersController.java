package com.example.demo.controller;

import com.example.demo.controller.response.ErrorResponse;
import com.example.demo.dto.UsersDto;
import com.example.demo.exceptions.AuthorityNotFoundException;
import com.example.demo.server.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<?> createUsers(@RequestBody UsersDto usersDto){
        try {
            return ResponseEntity.ok(usersService.createUsers(usersDto));
        }catch (IllegalArgumentException e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Invalid UUID format");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        catch (AuthorityNotFoundException e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Authority not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping
    public ResponseEntity<List<UsersDto>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }
}
