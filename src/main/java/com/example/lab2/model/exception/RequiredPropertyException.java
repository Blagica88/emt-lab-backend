package com.example.lab2.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequiredPropertyException extends RuntimeException{
    public RequiredPropertyException (String message){
        super(message);
    }
}
