package com.team4.ailearneye.entity;

import com.team4.ailearneye.enums.Morpheme;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
public class Word extends BaseEntity{

    private String word;
    private Morpheme morpheme;

}
