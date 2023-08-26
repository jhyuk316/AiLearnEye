package com.team4.ailearneye.service.dto;

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
        String[] split = text.split("[.?!]");
        long beginOffset = wordDto.getBeginOffset();

        int count = 0;
        for (int i = 0; i < split.length; i++) {
            count += split[i].length();
            if (count >= beginOffset) {
                return split[i].trim();
            }
        }

        return null;
    }

    public List<UserWordHistory> toEntity(long literacyId) {
        List<UserWordHistory> result = new ArrayList<>();

        List<WordDto> wordDtos = this.words;
        String[] split = text.split("[.?!]");
        for (int i = 0, wordDtosSize = wordDtos.size(); i < wordDtosSize; i++) {
            long beginOffset = wordDtos.get(i).getBeginOffset();

            int count = 0;
            long offset = 0;
            String newText = "";
            for (int j = 0; j < split.length; j++) {
                count += split[j].length();
                if (count >= beginOffset) {
                    newText = split[i].trim();
                    offset = beginOffset - count + split[j].length();
                }
            }

            WordDto word = wordDtos.get(i);
            UserWordHistory build = UserWordHistory.builder()
                    .literacyId(literacyId)
                    .quizId(i)
                    .word(word.word)
                    .memberId(1)
                    .time(word.time)
                    .rewindCount(word.rewindCount)
                    .text(newText)
                    .offset(offset)
                    .build();
            result.add(build);
        }

        return result;
    }
}
