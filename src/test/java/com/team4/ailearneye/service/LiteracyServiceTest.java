package com.team4.ailearneye.service;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class LiteracyServiceTest {

    @Test
    void init() {
        // AiCheckLiteracyResponse aiCheckLiteracyResponse = new AiCheckLiteracyResponse(null);
        //
        // List<UserWordHistory> entity = aiCheckLiteracyResponse.toEntity(1);
    }

    @Test
    void wet() {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("https://rfnndmekmjhxnsjg.tunnel-pt.elice.io/proxy/8222/", String.class);
        System.out.println("forObject = " + forObject);
    }
}