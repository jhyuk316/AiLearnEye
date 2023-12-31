package com.team4.ailearneye.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.team4.ailearneye.entity.Paragraph;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ParagraphDto(long paragraphId,
                           String title,
                           String text) {

    public static ParagraphDto of(Paragraph paragraph) {
        return new ParagraphDto(paragraph.getId(), paragraph.getTitle(), paragraph.getText());
    }
}
