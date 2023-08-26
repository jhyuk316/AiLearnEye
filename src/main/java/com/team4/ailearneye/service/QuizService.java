package com.team4.ailearneye.service;

import com.team4.ailearneye.api.dto.SolveRequest;
import com.team4.ailearneye.entity.UserParagraphWord;
import com.team4.ailearneye.entity.UserWordHistory;
import com.team4.ailearneye.repository.UserParagraphWordRepository;
import com.team4.ailearneye.repository.UserWordHistoryRepository;
import com.team4.ailearneye.service.dto.AiClient;
import com.team4.ailearneye.service.dto.AiGetQuizRequest;
import com.team4.ailearneye.service.dto.AiGetQuizResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class QuizService {

    private final AiClient aiClient;
    private final UserWordHistoryRepository userWordHistoryRepository;
    private final UserParagraphWordRepository userParagraphWordRepository;

    public AiGetQuizResponse getQuiz(long literacyId, long quizNumber) {
        if (aiClient.health()) {
            return new AiGetQuizResponse("가다의 의미로 적절한 것은?", List.of("1. 이동하다",
                    "2. 오다",
                    "3. 머물다",
                    "4. 돌아가다",
                    "5. 걷다"), 1);
        }

        RestTemplate restTemplate = new RestTemplate();
        UserWordHistory userWordHistory = userWordHistoryRepository
                .findByLiteracyIdAndQuizId(literacyId, quizNumber)
                .orElseThrow();

        AiGetQuizRequest aiGetQuizRequest = new AiGetQuizRequest(userWordHistory.getWord(), userWordHistory.getText(), userWordHistory.getOffset());

        ResponseEntity<AiGetQuizResponse> aiGetQuizResponse = restTemplate.postForEntity(AiClient.AI_URL + "/ai/quiz", aiGetQuizRequest, AiGetQuizResponse.class);

        return aiGetQuizResponse.getBody();
    }

    public String solve(SolveRequest solveRequest) {
        UserWordHistory userWordHistory = userWordHistoryRepository.findByLiteracyIdAndQuizId(solveRequest.literacyId(), solveRequest.quizNumber()).orElseThrow();
        if (SolveRequest.Answer.CORRECT.equals(solveRequest.answer())) {
            userWordHistory.setSolved(true);
        } else {
            userWordHistory.setSolved(false);
        }

        Optional<UserParagraphWord> byMemberIdAndWord = userParagraphWordRepository.findByMemberIdAndWord(1, userWordHistory.getWord());


        return "";
    }

}
