package com.team4.ailearneye.api.dto;

import com.team4.ailearneye.Utils;
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

    // public CheckLiteracyRequest(long paragraphId, String text, List<Integer> eyes) {
    //     int length = text.length();
    //     List<Integer> collect = eyes.stream()
    //             .filter(i -> i < length)
    //             .filter(i -> i > 0)
    //             .collect(Collectors.toList());
    //
    //     this.paragraphId = paragraphId;
    //     this.text = text;
    //     this.eyes = collect;
    // }

    public Literacy toEntity() {
        return Literacy.builder()
                .text(this.text)
                .eyes(Utils.toJson(this.eyes))
                .build();
    }

}
