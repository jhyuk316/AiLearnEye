package com.team4.ailearneye.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

public record CheckLiteracyRequest(
        // long userId,
        // long paragraphId,
        @NotBlank
        String text,

        @NotNull
        List<Integer> eyes) {

}
