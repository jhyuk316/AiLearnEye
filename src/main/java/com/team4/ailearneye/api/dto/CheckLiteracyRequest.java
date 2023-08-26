package com.team4.ailearneye.api.dto;

import lombok.Data;

public record CheckLiteracyRequest(
        long userId,
        long paragraphId,
        String paragraph,
        String eyeSequence) {

}
