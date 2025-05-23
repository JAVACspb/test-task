package com.yourorganization.testtask.exeption.handler.borrow;

import com.yourorganization.testtask.exeption.handler.ErrorCode;
import com.yourorganization.testtask.exeption.handler.ErrorResponse;
import com.yourorganization.testtask.exeption.type.borrow.BorrowNotFoundException;
import com.yourorganization.testtask.exeption.type.borrow.InvalidBorrowDataException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(2)
public class BorrowExceptionHandler {

    @ExceptionHandler(BorrowNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBorrowNotFoundException(BorrowNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(ErrorCode.BORROW_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidBorrowDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBorrowDataException(InvalidBorrowDataException ex) {
        ErrorResponse response = new ErrorResponse(ErrorCode.INVALID_BORROW_DATA, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
