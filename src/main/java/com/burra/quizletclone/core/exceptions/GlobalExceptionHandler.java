package com.burra.quizletclone.core.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> globaleExcpetionHandler(
      Exception ex,
      WebRequest request) {
    ErrorResponse errorDetails = new ErrorResponse(
        new Date(),
        HttpStatus.INTERNAL_SERVER_ERROR.toString(),
        ex.getMessage(),
        request.getDescription(false),
        ex.getClass().toString());
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
