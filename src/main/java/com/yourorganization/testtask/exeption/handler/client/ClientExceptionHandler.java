package com.yourorganization.testtask.exeption.handler.client;

import com.yourorganization.testtask.exeption.handler.ErrorCode;
import com.yourorganization.testtask.exeption.handler.ErrorResponse;
import com.yourorganization.testtask.exeption.type.client.ClientNotFoundException;
import com.yourorganization.testtask.exeption.type.client.InvalidClientDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientExceptionHandler {
    // Обработка исключения, когда клиент не найден
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClientNotFoundException(ClientNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(ErrorCode.CLIENT_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    // Обработка исключения, когда данные клиента некорректны
    @ExceptionHandler(InvalidClientDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidClientDataException(InvalidClientDataException ex) {
        ErrorResponse response = new ErrorResponse(ErrorCode.INVALID_CLIENT_DATA, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
