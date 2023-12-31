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
public class GeneratedSentence extends BaseEntity {

    private long literacyId;

    @Column(columnDefinition = "TEXT")
    private String text;
    
    @Column(columnDefinition = "TEXT")
    private String commentary;
}
