package com.example.lab2.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFound extends RuntimeException {

    public BookNotFound(){
        super("Book not found :'(");
    }
}
