package com.team4.ailearneye.service;

import com.team4.ailearneye.api.dto.SaveFavoriteSentenceRequest;
import com.team4.ailearneye.api.dto.SaveFavoriteSentenceResponse;
import com.team4.ailearneye.entity.FavoriteSentence;
import com.team4.ailearneye.repository.FavoriteSentenceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FavoriteSentenceService {

    private final FavoriteSentenceRepository favoriteSentenceRepository;

    public List<SaveFavoriteSentenceResponse> getFavoriteSentences(Long paragraphId) {
        List<FavoriteSentence> all;
        if (paragraphId != null) {
            all = favoriteSentenceRepository.findAllByParagraphId(paragraphId);
        } else {
            all = favoriteSentenceRepository.findAll();
        }
        return all.stream().map(SaveFavoriteSentenceResponse::of).collect(Collectors.toList());
    }

    public SaveFavoriteSentenceResponse saveFavoriteSentence(SaveFavoriteSentenceRequest request) {

        String comment = "";
        // todo ai 번역 요청

        //
        FavoriteSentence entity = request.toEntity(comment);
        favoriteSentenceRepository.save(entity);

        return SaveFavoriteSentenceResponse.of(entity);
    }


}
