package com.yourorganization.testtask.exeption.handler;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private ErrorCode code;
    private String message;

    public ErrorResponse(ErrorCode code, String message) {
        this.code = code;
        this.message = message;
    }
}
