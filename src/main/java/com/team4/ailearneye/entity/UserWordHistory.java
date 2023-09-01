package com.team4.ailearneye.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
public class UserWordHistory extends BaseEntity {

    private Long literacyId;
    private Long memberId;
    private Long quizId;

    private String word;
    private Long time;
    private Long rewindCount;

    @Column(columnDefinition = "TEXT")
    private String text;
    
    private Long beginOffset;

    private Boolean solved;

    public UserParagraphWord toEntity() {
        return UserParagraphWord.builder()
                .memberId(1L)
                .count(1L)
                .word(word)
                .averageTime(Double.valueOf(time))
                .rewindCount(rewindCount)
                .build();
    }
}
