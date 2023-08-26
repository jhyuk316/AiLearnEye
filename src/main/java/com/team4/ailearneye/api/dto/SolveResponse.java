package com.team4.ailearneye.api.dto;

public record SolveResponse(com.team4.ailearneye.api.dto.SolveResponse.Answer answer) {
    public enum Answer {
        CORRECT, WRONG
    }

}
