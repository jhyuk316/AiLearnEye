package com.team4.ailearneye.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.team4.ailearneye.entity.FavoriteSentence;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SaveFavoriteSentenceResponse(

        Long id,
        Long paragraphId,
        String sentence,
        String comment) {

    public static SaveFavoriteSentenceResponse of(FavoriteSentence favoriteSentence) {
        return new SaveFavoriteSentenceResponse(
                favoriteSentence.getId(),
                favoriteSentence.getParagraphId(),
                favoriteSentence.getSentence(),
                favoriteSentence.getCommentary()
        );
    }

}
