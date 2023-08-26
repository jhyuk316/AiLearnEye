package com.team4.ailearneye.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
public class UserParagraphWord extends BaseEntity {

    private Long memberId;
    // private long paragraphId;
    private String word;
    private Long count;
    private Long averageTime;
    private Long rewindCount;


}
