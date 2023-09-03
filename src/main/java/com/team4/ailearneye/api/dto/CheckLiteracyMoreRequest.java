package com.team4.ailearneye.api.dto;

import com.team4.ailearneye.Utils;
import com.team4.ailearneye.entity.LiteracyMore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CheckLiteracyMoreRequest(
        // long userId,

        Long literacyId,

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

    public LiteracyMore toLiteracyMore() {
        return LiteracyMore.builder()
                .text(this.text)
                .eyes(Utils.toJson(this.eyes))
                .build();
    }

}
