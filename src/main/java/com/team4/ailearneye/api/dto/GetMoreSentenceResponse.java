package com.team4.ailearneye.api.dto;

import com.team4.ailearneye.entity.GeneratedSentence;
import lombok.Data;

@Data
public class GetMoreSentenceResponse {

    private final String title;
    private final String text;
    private final String comment;

    public GeneratedSentence toEntity(long literacyId) {
        return GeneratedSentence.builder()
                .literacyId(literacyId)
                .text(text)
                .commentary(comment)
                .build();
    }
}
