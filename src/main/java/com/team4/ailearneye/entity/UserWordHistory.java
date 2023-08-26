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

    private long literacyId;
    private long memberId;
    private long quizId;

    private String word;
    private long time;
    private long rewindCount;

    @Column(length = 500)
    private String text;
    private long offset;

    private boolean isSolved;

}
