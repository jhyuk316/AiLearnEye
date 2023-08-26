package com.team4.ailearneye.api.dto;

public record SolveRequest(long literacyId, long quizNumber, Answer answer) {
    public enum Answer {
        CORRECT, WRONG
    }
}
