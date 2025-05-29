
package com.Globant.JobOffers.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse("Data not valid",ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DataInUseException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<Object> handleDataInUseException(DataInUseException ex){
        ErrorResponse errorResponse = new ErrorResponse("Data not valid",ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.ALREADY_REPORTED);
    }
    
    
    
    
}
