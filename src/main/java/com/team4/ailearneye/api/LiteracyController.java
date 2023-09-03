package com.team4.ailearneye.api;

import com.team4.ailearneye.api.dto.CheckLiteracyMoreRequest;
import com.team4.ailearneye.api.dto.CheckLiteracyRequest;
import com.team4.ailearneye.api.dto.CheckLiteracyResponse;
import com.team4.ailearneye.api.dto.GetMoreSentenceResponse;
import com.team4.ailearneye.service.LiteracyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("literacy")
public class LiteracyController {

    private final LiteracyService literacyService;

    @PostMapping
    public ResponseEntity<CheckLiteracyResponse> checkLiteracy(
            @RequestBody @Valid CheckLiteracyRequest checkLiteracyRequest) {

        log.info("checkLiteracyRequest:{}", checkLiteracyRequest);

        long l = literacyService.checkLiteracy(checkLiteracyRequest);

        return ResponseEntity.ok().body(new CheckLiteracyResponse(l));
    }

    @GetMapping("/{literacyId}/more")
    public ResponseEntity<GetMoreSentenceResponse> getMoreSentence(@PathVariable Long literacyId) {
        log.info("literacyId:{}", literacyId);
        GetMoreSentenceResponse moreSentence = literacyService.getMoreSentence(literacyId);
        return ResponseEntity.ok().body(moreSentence);
    }

    @PostMapping("/{literacyId}/more/check")
    public ResponseEntity<String> checkLiteracyMore(
            @PathVariable Long literacyId,
            @RequestBody @Valid CheckLiteracyMoreRequest checkLiteracyRequest) {
        log.info("literacyId:{}", literacyId);

        CheckLiteracyMoreRequest checkLiteracyMoreRequest = new CheckLiteracyMoreRequest(literacyId, checkLiteracyRequest.text(), checkLiteracyRequest.eyes());
        log.info("checkLiteracyMoreRequest:{}", checkLiteracyMoreRequest);
        long l = literacyService.checkLiteracyMore(checkLiteracyMoreRequest);
        return ResponseEntity.ok().body("OK");
    }

}
