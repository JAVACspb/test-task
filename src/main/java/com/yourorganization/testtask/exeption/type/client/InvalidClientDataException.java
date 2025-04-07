package com.yourorganization.testtask.exeption.type.client;

public class InvalidClientDataException extends RuntimeException {
    public InvalidClientDataException(String message) {
        super(message);
    }
}
