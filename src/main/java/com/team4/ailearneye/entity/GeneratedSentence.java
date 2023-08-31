package com.team4.ailearneye.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
public class GeneratedSentence extends BaseEntity {

    private long literacyId;
    private String text;
    private String commentary;
}
