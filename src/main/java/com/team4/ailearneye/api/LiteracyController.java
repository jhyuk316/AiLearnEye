package com.team4.ailearneye.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("literacy")
public class LiteracyController {

    @PostMapping
    public ResponseEntity<String> checkLiteracy(){


        return ResponseEntity.ok().body("");
    }
}
