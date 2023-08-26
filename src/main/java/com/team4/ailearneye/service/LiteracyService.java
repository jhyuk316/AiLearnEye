package com.team4.ailearneye.service;

import com.team4.ailearneye.api.dto.CheckLiteracyRequest;
import com.team4.ailearneye.entity.Literacy;
import com.team4.ailearneye.entity.UserWordHistory;
import com.team4.ailearneye.repository.LiteracyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LiteracyService {

    private final LiteracyRepository literacyRepository;

    public long checkLiteracy(CheckLiteracyRequest checkLiteracyRequest) {

        //
        AiCheckLiteracyResponse aiCheckLiteracyResponse = new AiCheckLiteracyResponse("", null);
        Literacy literacy = checkLiteracyRequest.toEntity();

        literacyRepository.save(literacy);
        long literacyId = literacy.getId();

        if (false) {
            List<UserWordHistory> entity = aiCheckLiteracyResponse.toEntity(literacyId);
        }

        return literacyId;
    }
}
