package com.team4.ailearneye.service.dto;

import java.util.List;

public record AiGetQuizResponse(
        String question,
        List<String> choices,
        int answer) {
}
