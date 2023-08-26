package com.team4.ailearneye.service;

import com.team4.ailearneye.api.dto.ParagraphDto;
import com.team4.ailearneye.api.dto.ParagraphListDto;
import com.team4.ailearneye.entity.Paragraph;
import com.team4.ailearneye.repository.ParagraphRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParagraphService {

    private final ParagraphRepository paragraphRepository;

    public ParagraphListDto getParagraphs() {
        List<Paragraph> all = paragraphRepository.findAll();
        return ParagraphListDto.of(all);
    }

    public ParagraphDto getParagraphs(long id) {
        Paragraph paragraph = paragraphRepository.findById(id).orElseThrow();
        return ParagraphDto.of(paragraph);
    }
}
