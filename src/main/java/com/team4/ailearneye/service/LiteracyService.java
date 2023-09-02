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
import com.team4.ailearneye.service.dto.AiGetSentenceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

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

        List<UserWordHistory> userWordHistoryList = userWordHistoryRepository.findAllByLiteracyId(literacyId);
        List<String> words = userWordHistoryList.stream().map(UserWordHistory::getWord).collect(Collectors.toList());

        // AI 지문 생성 요청
        if (words.isEmpty()) {
            words = List.of("Succinct", "Commiserate", "modern", "economical", "natural");
            log.error("임의로 질문 생성");
        }

        AiGetSentenceRequest aiGetSentenceRequest = new AiGetSentenceRequest(words);

        GetMoreSentenceResponse getMoreSentenceResponse = null;
        try {
            ResponseEntity<GetMoreSentenceResponse> getMoreSentenceResponseResponseEntity = restTemplate.postForEntity("https://spjgd7e8jd.execute-api.ap-northeast-2.amazonaws.com/default/getSentence", aiGetSentenceRequest, GetMoreSentenceResponse.class);
            if (getMoreSentenceResponseResponseEntity.getStatusCode().is2xxSuccessful()) {
                getMoreSentenceResponse = getMoreSentenceResponseResponseEntity.getBody();
                log.info("getMoreSentenceResponse:{}", getMoreSentenceResponse);
            }
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }

        if (getMoreSentenceResponse == null) {
            getMoreSentenceResponse = new GetMoreSentenceResponse("In our modern world, it is essential to find economical and natural solutions to problems and, in doing so, commiserate with a succinct understanding of the challenges we face.", "현대 세상에서는 문제에 대한 경제적이고 자연스러운 해결책을 찾는 것이 중요하며, 이를 통해 우리는 간결한 이해와 함께 그 문제에 공감합니다.");
            log.error("임의로 응답 생성");
        }

        GeneratedSentence entity = getMoreSentenceResponse.toEntity(literacyId);
        generatedSentenceRepository.save(entity);
        return getMoreSentenceResponse;
    }
}
