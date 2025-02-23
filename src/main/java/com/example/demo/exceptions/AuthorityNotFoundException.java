package com.example.demo.exceptions;

public class AuthorityNotFoundException extends RuntimeException {
    public AuthorityNotFoundException(String message){
        super(message);
    }
}
