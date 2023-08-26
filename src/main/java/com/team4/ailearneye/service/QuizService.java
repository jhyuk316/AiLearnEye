package com.team4.ailearneye.service;

import com.team4.ailearneye.api.dto.SolveRequest;
import com.team4.ailearneye.entity.UserWordHistory;
import com.team4.ailearneye.repository.UserWordHistoryRepository;
import com.team4.ailearneye.service.dto.AiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class QuizService {

    private final AiClient aiClient;
    private final UserWordHistoryRepository userWordHistoryRepository;

    public String getQuiz(long literacyId, long quizNumber) {
        aiClient.health();

        RestTemplate restTemplate = new RestTemplate();

        Optional<UserWordHistory> byLiteracyIdAndQuizId = userWordHistoryRepository.findByLiteracyIdAndQuizId(literacyId, quizNumber);

        restTemplate.postForEntity(AiClient.AI_URL+"/ai/quiz",)


        return "";
    }

    public String solve(SolveRequest solveRequest) {
        UserWordHistory userWordHistory = userWordHistoryRepository.findByLiteracyIdAndQuizId(solveRequest.literacyId(), solveRequest.quizNumber()).orElseThrow();
        if (SolveRequest.Answer.CORRECT.equals(solveRequest.answer())) {
            userWordHistory.setSolved(true);
        } else {
            userWordHistory.setSolved(false);
        }

        return "";
    }

}
