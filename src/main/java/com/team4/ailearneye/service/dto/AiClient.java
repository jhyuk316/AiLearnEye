package com.team4.ailearneye.service.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class AiClient {
    public static final String AI_URL = "https://rfnndmekmjhxnsjg.tunnel-pt.elice.io/proxy/8222/";

    public void health() {
        RestTemplate restTemplate = new RestTemplate();
        String health = restTemplate.getForObject(AI_URL, String.class);
        log.info("health:{}", health);
    }
}
