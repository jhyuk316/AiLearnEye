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

    private long memberId;
    private long paragraphId;
    private long wordId;
    private long count;
    private long averageTime;
    private long rewindCount;


}
