package com.team4.ailearneye.service;

import com.team4.ailearneye.enums.Morpheme;
import org.junit.jupiter.api.Test;

import java.util.List;

class AiCheckLiteracyResponseTest {

    @Test
    void getTextInWord() {
        AiCheckLiteracyResponse.WordDto na = new AiCheckLiteracyResponse.WordDto("나", Morpheme.NNP, 23, 2, 7);
        AiCheckLiteracyResponse aiCheckLiteracyResponse = new AiCheckLiteracyResponse(
                "가나1다라. 가나2다라. 가나3다라. 가나4다라.",
                List.of(na));

        String textInWord = aiCheckLiteracyResponse.getTextInWord(na);
        System.out.println("textInWord = " + textInWord);

    }
}