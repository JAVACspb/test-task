package com.yourorganization.testtask.exeption.handler.borrow;

import com.yourorganization.testtask.exeption.handler.ErrorCode;
import com.yourorganization.testtask.exeption.handler.ErrorResponse;
import com.yourorganization.testtask.exeption.type.borrow.BorrowNotFoundException;
import com.yourorganization.testtask.exeption.type.borrow.InvalidBorrowDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BorrowExceptionHandler {

    // Обработка исключения, когда запись Borrow не найдена
    @ExceptionHandler(BorrowNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBorrowNotFoundException(BorrowNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(ErrorCode.BORROW_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Обработка исключения, когда данные о Borrow некорректны
    @ExceptionHandler(InvalidBorrowDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBorrowDataException(InvalidBorrowDataException ex) {
        ErrorResponse response = new ErrorResponse(ErrorCode.INVALID_BORROW_DATA, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
