package com.pharmahub.cancellationordersqs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.pharmahub.cancellationordersqs.contracts.responses.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResult = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        ErrorResponse errorResult  = new ErrorResponse("uno o mas campos son incorrectos", HttpStatus.BAD_REQUEST.value());

        for(var error : result.getFieldErrors()) {
            errorResult
                    .addErrorDetails(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }
}
