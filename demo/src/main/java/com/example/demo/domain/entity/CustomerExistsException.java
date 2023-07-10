package com.example.demo.domain.entity;

public class CustomerExistsException extends Exception{
    public CustomerExistsException(){

    }
    public CustomerExistsException(String message){
        super(message);
    }
    public CustomerExistsException(String message, Throwable cause){
        super(message, cause);
    }
}
