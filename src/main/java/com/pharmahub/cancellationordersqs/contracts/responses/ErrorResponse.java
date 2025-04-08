package com.pharmahub.cancellationordersqs.contracts.responses;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {

    public ErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
    private String message;
    private int statusCode;
    private List<ErrorDetails> errors = new ArrayList<>();;

    public void addErrorDetails(String field, String message) {
        errors.add(new ErrorDetails(field, message));
    }
}

@Data class ErrorDetails {
    public ErrorDetails(String field, String message) {
        this.field = field;
        this.message = message;
    }
    private String field;
    private String message;
}
