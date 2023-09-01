package com.team4.ailearneye.api;

import com.team4.ailearneye.api.dto.SaveFavoriteSentenceRequest;
import com.team4.ailearneye.api.dto.SaveFavoriteSentenceResponse;
import com.team4.ailearneye.service.FavoriteSentenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("favorite-sentences")
@RequiredArgsConstructor
public class FavoriteSentenceController {

    private final FavoriteSentenceService favoriteSentenceService;


    @GetMapping
    public ResponseEntity<List<SaveFavoriteSentenceResponse>> getFavoriteSentences(
            @RequestParam(required = false) Long paragraphId) {

        log.info("paragraphId:{}", paragraphId);
        List<SaveFavoriteSentenceResponse> favoriteSentences = favoriteSentenceService.getFavoriteSentences(paragraphId);
        return ResponseEntity.ok().body(favoriteSentences);

    }

    @PostMapping
    public ResponseEntity<SaveFavoriteSentenceResponse> saveFavoriteSentence(@Valid @RequestBody SaveFavoriteSentenceRequest request) {
        log.info("saveFavoriteSentence request:{}", request);
        SaveFavoriteSentenceResponse saveFavoriteSentenceResponse = favoriteSentenceService.saveFavoriteSentence(request);
        return ResponseEntity.ok().body(saveFavoriteSentenceResponse);
    }
}
