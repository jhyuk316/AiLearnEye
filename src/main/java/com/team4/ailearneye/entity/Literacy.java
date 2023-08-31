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
public class Literacy extends BaseEntity {

    @Column(length = 1000)
    private String text;
    @Column(columnDefinition = "TEXT")
    private String eyes;

}
