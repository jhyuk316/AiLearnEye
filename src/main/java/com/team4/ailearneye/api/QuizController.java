package com.team4.ailearneye.api;

import com.team4.ailearneye.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("quiz")
public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public ResponseEntity<?> getQuiz(@RequestParam("literacyId") long literacyId) {


        return ResponseEntity.ok().build();
    }


}
