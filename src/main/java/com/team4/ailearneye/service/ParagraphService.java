package com.team4.ailearneye.service;

import com.google.gson.Gson;
import com.team4.ailearneye.api.dto.ParagraphDto;
import com.team4.ailearneye.api.dto.ParagraphListDto;
import com.team4.ailearneye.entity.Paragraph;
import com.team4.ailearneye.repository.ParagraphRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ParagraphService {

    private final ParagraphRepository paragraphRepository;
    private final Gson gsonPretty;

    public ParagraphListDto getParagraphs() {
        List<Paragraph> all = paragraphRepository.findAll();
        log.info("all:{}", gsonPretty.toJson(all));
        return ParagraphListDto.of(all);
    }

    public ParagraphDto getParagraphs(long id) {
        Paragraph paragraph = paragraphRepository.findById(id).orElseThrow();
        return ParagraphDto.of(paragraph);
    }
}
