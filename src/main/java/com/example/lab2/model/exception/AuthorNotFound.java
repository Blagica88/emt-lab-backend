package com.example.lab2.model.exception;

import com.example.lab2.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AuthorNotFound extends RuntimeException {

    public AuthorNotFound(){
        super("Author not found :'(");
    }
}
