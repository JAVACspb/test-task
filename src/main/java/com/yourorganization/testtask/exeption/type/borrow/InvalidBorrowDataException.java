package com.yourorganization.testtask.exeption.type.borrow;

public class InvalidBorrowDataException extends RuntimeException {
    public InvalidBorrowDataException(String message) {
        super(message);
    }
}

