package com.team4.ailearneye.service.dto;

import com.team4.ailearneye.entity.UserWordHistory;
import com.team4.ailearneye.enums.Morpheme;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AiCheckLiteracyResponse {

    // private final String text;
    private final List<WordDto> words;

    @Data
    public static class WordDto {
        private final String word;
        private final Morpheme morpheme;
        private final long time;
        private final long rewindCount;
        private final long beginOffset;
        private final String sentence;

    }

    public List<UserWordHistory> toEntity(long literacyId) {
        List<UserWordHistory> result = new ArrayList<>();

        List<WordDto> wordDtos = this.words;
        for (int i = 0; i < wordDtos.size(); i++) {
            WordDto word = wordDtos.get(i);
            UserWordHistory build = UserWordHistory.builder()
                    .literacyId(literacyId)
                    .quizId(i)
                    .word(word.word)
                    .memberId(1)
                    .time(word.time)
                    .rewindCount(word.rewindCount)
                    .text(word.sentence)
                    .offset(word.beginOffset)
                    .build();
            result.add(build);
        }
        return result;
    }
}
