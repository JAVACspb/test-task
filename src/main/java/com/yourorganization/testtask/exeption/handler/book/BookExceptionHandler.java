package com.yourorganization.testtask.exeption.handler.book;

import com.yourorganization.testtask.exeption.handler.ErrorCode;
import com.yourorganization.testtask.exeption.handler.ErrorResponse;
import com.yourorganization.testtask.exeption.type.book.BookNotFoundException;
import com.yourorganization.testtask.exeption.type.book.InvalidBookDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(ErrorCode.BOOK_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidBookDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBookDataException(InvalidBookDataException ex) {
        ErrorResponse response = new ErrorResponse(ErrorCode.INVALID_BOOK_DATA, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
