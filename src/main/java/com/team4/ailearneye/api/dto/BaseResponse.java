package com.team4.ailearneye.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.team4.ailearneye.exceptions.ErrorCode;
import lombok.Data;

@Data
@JsonPropertyOrder({"code", "message", "data"})
public class BaseResponse<T> {
    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public BaseResponse(T data) {
        this.code = ErrorCode.SUCCESS.name();
        this.message = ErrorCode.SUCCESS.getMessage();
        this.data = data;
    }

    public BaseResponse(ErrorCode code) {
        this.code = code.name();
        this.message = code.getMessage();
    }
}
