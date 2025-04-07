package com.yourorganization.testtask.exeption.type.client;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
