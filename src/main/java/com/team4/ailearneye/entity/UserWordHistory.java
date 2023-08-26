package com.team4.ailearneye.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
public class UserWordHistory extends BaseEntity {

    private long literacyId;
    private long memberId;
    private String word;
    private long time;
    private long rewindCount;

    @Column(length = 500)
    private String text;

}
