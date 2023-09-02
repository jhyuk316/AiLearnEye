package com.team4.ailearneye.api.dto;

import com.team4.ailearneye.entity.GeneratedSentence;

public record GetMoreSentenceResponse(String text, String comment) {

    public GeneratedSentence toEntity(long literacyId) {
        return GeneratedSentence.builder()
                .literacyId(literacyId)
                .text(text)
                .commentary(comment)
                .build();
    }
}
