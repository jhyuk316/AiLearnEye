package com.team4.ailearneye.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    SUCCESS(HttpStatus.OK, "OK"),
    INVALID_PARAM(HttpStatus.BAD_REQUEST, "Invalid Parameter"),
    NOT_FOUND(HttpStatus.BAD_REQUEST, "Not Found Data"),
    UNKNOWN(HttpStatus.BAD_REQUEST, "Unknown");

    private final HttpStatus httpStatus;
    private final String message;
}
