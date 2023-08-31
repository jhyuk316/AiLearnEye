package com.team4.ailearneye.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CommonApiController {

    @GetMapping("health")
    public ResponseEntity<String> health() {
        log.info("health");
        return ResponseEntity.ok().body("OK");
    }
}
