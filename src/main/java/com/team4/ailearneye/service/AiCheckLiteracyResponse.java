package com.team4.ailearneye.service;

import com.team4.ailearneye.entity.UserWordHistory;
import com.team4.ailearneye.enums.Morpheme;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AiCheckLiteracyResponse {

    private final String text;
    private final List<WordDto> words;

    @Data
    public static class WordDto {
        private final String word;
        private final Morpheme morpheme;
        private final long time;
        private final long rewindCount;
        private final long beginOffset;

    }

    public String getTextInWord(WordDto wordDto) {
        String[] split = text.split("\\.");
        long beginOffset = wordDto.getBeginOffset();

        int count = 0;
        for (int i = 0; i < split.length; i++) {
            count += split[i].length();
            if (count >= beginOffset) {
                return split[i];
            }
        }

        return null;
    }

    public List<UserWordHistory> toEntity(long literacyId) {
        List<UserWordHistory> result = new ArrayList<>();
        for (var word : this.words) {

            UserWordHistory build = UserWordHistory.builder()
                    .literacyId(literacyId)
                    .word(word.word)
                    .memberId(1)
                    .time(word.time)
                    .rewindCount(word.rewindCount)
                    .text(getTextInWord(word)).build();
            result.add(build);
        }
        
        return result;
    }
}
