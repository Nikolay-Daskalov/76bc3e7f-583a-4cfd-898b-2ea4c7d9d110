package com.project.Covid19Statistics.web.exception;

import org.springframework.http.HttpStatus;

public class CountryInfoException extends RuntimeException{

    private final String message;
    private final HttpStatus httpStatus;

    public CountryInfoException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
