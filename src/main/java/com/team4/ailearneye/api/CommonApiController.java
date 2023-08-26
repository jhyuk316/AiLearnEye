package com.team4.ailearneye.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonApiController {

    @GetMapping("health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok().body("OK");
    }
}
