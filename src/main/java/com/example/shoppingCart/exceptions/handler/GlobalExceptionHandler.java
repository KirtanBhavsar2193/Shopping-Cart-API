package com.example.shoppingCart.exceptions.handler;

import com.example.shoppingCart.exceptions.DataNotFoundException;
import com.example.shoppingCart.exceptions.DataValidationException;
import com.example.shoppingCart.model.error.ErrorResponse;
import com.example.shoppingCart.model.error.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.shoppingCart")
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerDataNotFoundException(DataNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ErrorType.MISSING_DATA);

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DataValidationException.class})
    public ResponseEntity<ErrorResponse> handlerDataValidationException(DataValidationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ErrorType.INVALID_DATA);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerGlobalException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("An Unexpected Error Occurred", ErrorType.INTERNAL_ERROR);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
