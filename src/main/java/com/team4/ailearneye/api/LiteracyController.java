package com.team4.ailearneye.api;

import com.team4.ailearneye.api.dto.CheckLiteracyRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("literacy")
public class LiteracyController {

    @PostMapping
    public ResponseEntity<String> checkLiteracy(CheckLiteracyRequest checkLiteracyRequest){


        return ResponseEntity.ok().body("");
    }
}
