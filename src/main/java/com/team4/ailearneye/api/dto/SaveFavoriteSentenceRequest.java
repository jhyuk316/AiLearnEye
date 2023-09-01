package com.team4.ailearneye.api.dto;

import com.team4.ailearneye.entity.FavoriteSentence;
import jakarta.validation.constraints.NotBlank;

public record SaveFavoriteSentenceRequest(
        Long paragraphId,
        @NotBlank String sentence) {

    public FavoriteSentence toEntity(String commentary) {
        // long l = this.paragraphId == null ? -1 : this.paragraphId;
        return FavoriteSentence.builder()
                .paragraphId(this.paragraphId)
                .sentence(this.sentence)
                .commentary(commentary)
                .build();
    }
}
