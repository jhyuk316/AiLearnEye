package com.team4.ailearneye.api.dto;

import com.team4.ailearneye.entity.Paragraph;

import java.util.List;
import java.util.stream.Collectors;

public record ParagraphListDto(List<ParagraphTitle> paragraphs) {

    public static ParagraphListDto of(List<Paragraph> paragraphs) {
        List<ParagraphTitle> collect = paragraphs.stream().map(ParagraphTitle::new).collect(Collectors.toList());
        return new ParagraphListDto(collect);
    }

    public record ParagraphTitle(long paragraphId, String title) {
        public ParagraphTitle(Paragraph paragraph) {
            this(paragraph.getId(), paragraph.getTitle());
        }
    }

}
