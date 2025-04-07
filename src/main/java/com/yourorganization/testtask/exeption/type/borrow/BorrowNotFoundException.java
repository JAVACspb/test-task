package com.yourorganization.testtask.exeption.type.borrow;

public class BorrowNotFoundException extends RuntimeException {
    public BorrowNotFoundException(String message) {
        super(message);
    }
}
