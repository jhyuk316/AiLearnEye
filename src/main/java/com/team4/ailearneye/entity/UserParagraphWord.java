package com.team4.ailearneye.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Setter
public class UserParagraphWord extends BaseEntity {

    private Long memberId;
    // private long paragraphId;
    private String word;
    private Long count;
    private Double averageTime;
    private Long rewindCount;


}
