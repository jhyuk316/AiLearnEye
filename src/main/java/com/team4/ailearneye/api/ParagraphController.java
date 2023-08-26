package com.team4.ailearneye.api;

import com.team4.ailearneye.api.dto.ParagraphDto;
import com.team4.ailearneye.api.dto.ParagraphListDto;
import com.team4.ailearneye.service.ParagraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("paragraphs")
public class ParagraphController {

    private final ParagraphService paragraphService;


    @GetMapping
    public ResponseEntity<ParagraphListDto> getParagraphs(){

        ParagraphListDto paragraphs = paragraphService.getParagraphs();

        return ResponseEntity.ok().body(paragraphs);
    }

    @GetMapping("/{paragraphId}")
    public ResponseEntity<ParagraphDto> getParagraphs(@PathVariable long paragraphId){
        ParagraphDto paragraphs = paragraphService.getParagraphs(paragraphId);
        return ResponseEntity.ok().body(paragraphs);
    }

}
