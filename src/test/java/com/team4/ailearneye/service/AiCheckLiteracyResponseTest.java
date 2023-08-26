package com.team4.ailearneye.service;

import com.team4.ailearneye.enums.Morpheme;
import com.team4.ailearneye.service.dto.AiCheckLiteracyResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

class AiCheckLiteracyResponseTest {

    @Test
    void getTextInWord() {
        AiCheckLiteracyResponse.WordDto na = new AiCheckLiteracyResponse.WordDto("나", Morpheme.NNP, 23, 2, 7, "sentence");
        AiCheckLiteracyResponse aiCheckLiteracyResponse = new AiCheckLiteracyResponse(List.of(na));


    }
}