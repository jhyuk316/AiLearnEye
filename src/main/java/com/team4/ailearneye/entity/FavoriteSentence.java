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
public class FavoriteSentence extends BaseEntity {

    private long paragraphId;

    @Column(columnDefinition = "TEXT")
    private String sentence;

    @Column(columnDefinition = "TEXT")
    private String commentary;

}
