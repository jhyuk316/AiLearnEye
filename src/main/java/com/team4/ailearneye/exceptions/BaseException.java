package com.team4.ailearneye.exceptions;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {
    private final ErrorCode errorCode;
}
