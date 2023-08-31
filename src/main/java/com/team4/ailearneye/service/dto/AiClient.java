package com.team4.ailearneye.service.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class AiClient {
    // public static final String AI_URL = "https://rfnndmekmjhxnsjg.tunnel-pt.elice.io/proxy/8222/";
    public static final String AI_URL = "https://dijt3c982f.execute-api.ap-northeast-2.amazonaws.com/default/skt_hack/";

    public boolean health() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> forEntity = restTemplate.getForEntity(AI_URL, String.class);
            log.info("health:{}", forEntity.getBody());
            return forEntity.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }
}
