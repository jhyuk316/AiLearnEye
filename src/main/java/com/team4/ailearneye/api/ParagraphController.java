package com.team4.ailearneye.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paragraphs")
public class ParagraphController {

    @GetMapping
    public ResponseEntity<String> getParagraphs(){
        return ResponseEntity.ok().body("");
    }

    @GetMapping("/{paragraphId}")
    public ResponseEntity<String> getParagraphs(@PathVariable long paragraphId){
        return ResponseEntity.ok().body("");
    }

}
