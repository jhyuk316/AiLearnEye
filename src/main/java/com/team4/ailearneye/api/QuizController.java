package com.team4.ailearneye.api;

import com.team4.ailearneye.api.dto.SolveRequest;
import com.team4.ailearneye.service.QuizService;
import com.team4.ailearneye.service.dto.AiGetQuizResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("quiz")
public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public ResponseEntity<AiGetQuizResponse> getQuiz(@RequestParam("literacyId") long literacyId,
                                                     @RequestParam("quizNumber") long quizNumber) {
        AiGetQuizResponse quiz = quizService.getQuiz(literacyId, quizNumber);
        return ResponseEntity.ok().body(quiz);
    }

    @PostMapping("solve")
    public ResponseEntity<?> solve(@RequestBody SolveRequest solveRequest) {
        quizService.solve(solveRequest);
        return ResponseEntity.ok().build();
    }

}
