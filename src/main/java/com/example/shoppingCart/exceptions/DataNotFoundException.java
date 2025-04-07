package com.example.shoppingCart.exceptions;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
