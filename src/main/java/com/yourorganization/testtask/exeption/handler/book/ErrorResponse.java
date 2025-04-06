package com.yourorganization.testtask.exeption.handler.book;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final String errorCode;
    private final String message;

    public ErrorResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
