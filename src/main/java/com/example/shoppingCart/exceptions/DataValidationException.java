package com.example.shoppingCart.exceptions;

import lombok.Data;

import java.io.Serial;

@Data
public class DataValidationException extends RuntimeException {
    public DataValidationException(String message) {
        super(message);
    }
}
