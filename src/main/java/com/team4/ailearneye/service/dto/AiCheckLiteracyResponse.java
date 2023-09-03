package com.team4.ailearneye.service.dto;

import com.team4.ailearneye.entity.UserWordHistory;
import com.team4.ailearneye.entity.UserWordMoreHistory;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AiCheckLiteracyResponse {

    // private final String text;
    private List<WordDto> words;

    @Data
    @NoArgsConstructor
    public static class WordDto {
        private String word;
        // private final Morpheme morpheme;
        private long time;
        private long rewindCount;
        private String sentence;
        private long beginOffset;

    }

    public List<UserWordHistory> toUserWordHistorys(long literacyId) {
        List<UserWordHistory> result = new ArrayList<>();

        List<WordDto> wordDtos = this.words;
        for (int i = 0; i < wordDtos.size(); i++) {
            WordDto word = wordDtos.get(i);
            UserWordHistory build = UserWordHistory.builder()
                    .literacyId(literacyId)
                    .quizId((long) i)
                    .word(word.word)
                    .memberId(1L)
                    .time(word.time)
                    .rewindCount(word.rewindCount)
                    .text(word.sentence)
                    .beginOffset(word.beginOffset)
                    .build();
            result.add(build);
        }
        return result;
    }

    public List<UserWordMoreHistory> toUserWordMoreHistorys(long literacyId) {
        List<UserWordMoreHistory> result = new ArrayList<>();

        List<WordDto> wordDtos = this.words;
        for (int i = 0; i < wordDtos.size(); i++) {
            WordDto word = wordDtos.get(i);
            UserWordMoreHistory build = UserWordMoreHistory.builder()
                    .literacyId(literacyId)
                    .quizId((long) i)
                    .word(word.word)
                    .memberId(1L)
                    .time(word.time)
                    .rewindCount(word.rewindCount)
                    .text(word.sentence)
                    .beginOffset(word.beginOffset)
                    .build();
            result.add(build);
        }
        return result;
    }
}
