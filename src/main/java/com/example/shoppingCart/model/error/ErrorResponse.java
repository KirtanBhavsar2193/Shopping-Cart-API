package com.example.shoppingCart.model.error;

import lombok.Data;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String message;
    private ErrorType status;
    private LocalDateTime timeStamp;

    public ErrorResponse(String message, ErrorType value) {
        this.message = message;
        this.status = value;
        this.timeStamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ErrorType getStatus() {
        return status;
    }

    public void setStatus(ErrorType status) {
        this.status = status;
    }
}
