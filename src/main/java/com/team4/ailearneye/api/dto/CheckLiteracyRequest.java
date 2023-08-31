package com.team4.ailearneye.api.dto;

import com.team4.ailearneye.entity.Literacy;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CheckLiteracyRequest(
        // long userId,
        long paragraphId,
        @NotBlank
        String text,

        @NotNull
        List<Integer> eyes) {

    public Literacy toEntity() {
        return Literacy.builder()
                .text(this.text)
                // .eyes(Utils.toJson(this.eyes))
                .build();
    }

}
