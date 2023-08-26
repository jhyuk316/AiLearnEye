package com.team4.ailearneye.api;

import com.team4.ailearneye.api.dto.CheckLiteracyRequest;
import com.team4.ailearneye.service.LiteracyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("literacy")
public class LiteracyController {

    private final LiteracyService literacyService;

    @PostMapping
    public ResponseEntity<Object> checkLiteracy(
            @RequestBody @Valid CheckLiteracyRequest checkLiteracyRequest){

        log.info("checkLiteracyRequest:{}",checkLiteracyRequest);

        literacyService.checkLiteracy(checkLiteracyRequest);

        return ResponseEntity.ok().build();
    }
}
