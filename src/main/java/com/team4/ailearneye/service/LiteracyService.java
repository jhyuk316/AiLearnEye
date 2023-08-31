package com.team4.ailearneye.service;

import com.team4.ailearneye.api.dto.CheckLiteracyRequest;
import com.team4.ailearneye.api.dto.GetMoreSentenceResponse;
import com.team4.ailearneye.entity.GeneratedSentence;
import com.team4.ailearneye.entity.Literacy;
import com.team4.ailearneye.entity.UserWordHistory;
import com.team4.ailearneye.repository.GeneratedSentenceRepository;
import com.team4.ailearneye.repository.LiteracyRepository;
import com.team4.ailearneye.repository.UserWordHistoryRepository;
import com.team4.ailearneye.service.dto.AiCheckLiteracyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LiteracyService {

    public static final String AI_URL = "https://rfnndmekmjhxnsjg.tunnel-pt.elice.io/proxy/8222/";
    private final LiteracyRepository literacyRepository;
    private final UserWordHistoryRepository userWordHistoryRepository;
    private final GeneratedSentenceRepository generatedSentenceRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    // private final AiClient aiClient;

    public long checkLiteracy(CheckLiteracyRequest checkLiteracyRequest) {
        Literacy literacy = checkLiteracyRequest.toEntity();

        log.info("literacy:{}", literacy);
        literacyRepository.save(literacy);
        long literacyId = literacy.getId();

        // if (!aiClient.health()) {
        //     return -1;
        // }

        // ai 호출

        // ResponseEntity<AiCheckLiteracyResponse> aiCheckLiteracyResponseResponseEntity = restTemplate.postForEntity(AI_URL + "/ai/checkLiteracy", checkLiteracyRequest, AiCheckLiteracyResponse.class);
        ResponseEntity<AiCheckLiteracyResponse> aiCheckLiteracyResponseResponseEntity = restTemplate.postForEntity("https://dijt3c982f.execute-api.ap-northeast-2.amazonaws.com/default/skt_hack", checkLiteracyRequest, AiCheckLiteracyResponse.class);

        AiCheckLiteracyResponse aiCheckLiteracyResponse = aiCheckLiteracyResponseResponseEntity.getBody();

        log.info("aiCheckLiteracyResponse:{}", aiCheckLiteracyResponse);

        // String forObject = restTemplate.getForObject(AI_URL, String.class);
        // log.debug("{}", forObject);

        assert aiCheckLiteracyResponse != null;
        List<UserWordHistory> entity = aiCheckLiteracyResponse.toEntity(literacyId);
        log.debug("entity:{}", entity);
        userWordHistoryRepository.saveAll(entity);

        return literacyId;
    }

    public GetMoreSentenceResponse getMoreSentence(long literacyId) {

        // AI 지문 생성 요청
        List<String> words = List.of("Succinct", "Commiserate", "modern", "economical", "natural");
        // ResponseEntity<GetMoreSentenceResponse> getMoreSentenceResponseResponseEntity = restTemplate.postForEntity("https://dijt3c982f.execute-api.ap-northeast-2.amazonaws.com/default/skt_hack", words, GetMoreSentenceResponse.class);
        // GetMoreSentenceResponse getMoreSentenceResponse = getMoreSentenceResponseResponseEntity.getBody();

        GetMoreSentenceResponse getMoreSentenceResponse = new GetMoreSentenceResponse("title", "new Sentence", "comment");
        GeneratedSentence entity = getMoreSentenceResponse.toEntity(literacyId);
        generatedSentenceRepository.save(entity);

        return getMoreSentenceResponse;
    }
}
