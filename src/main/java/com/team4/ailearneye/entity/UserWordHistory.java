package com.team4.ailearneye.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
public class UserWordHistory extends BaseEntity{

    private long literacyId;
    private long memberId;
    private long wordId;
    private long time;
    private long rewindCount;


}
