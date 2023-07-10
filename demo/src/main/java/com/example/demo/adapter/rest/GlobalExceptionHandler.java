package com.example.demo.adapter.rest;

import com.example.demo.domain.entity.CustomerDoesntExistException;
import com.example.demo.domain.entity.CustomerExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(value = CustomerExistsException.class)
    public ResponseEntity<String> handleException(CustomerExistsException customerExistsException){
        return new ResponseEntity<>(customerExistsException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = CustomerDoesntExistException.class)
    public ResponseEntity<String> handleException(CustomerDoesntExistException customerDoesntExistException){
        return new ResponseEntity<>(customerDoesntExistException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
