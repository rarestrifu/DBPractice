package com.example.demo.domain.entity;

public class CustomerDoesntExistException extends Exception{
    public CustomerDoesntExistException(){

    }
    public CustomerDoesntExistException(String message){
        super(message);
    }
    public CustomerDoesntExistException(String message, Throwable cause){
        super(message, cause);
    }
}
