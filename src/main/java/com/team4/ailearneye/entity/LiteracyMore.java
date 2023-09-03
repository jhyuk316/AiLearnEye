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
public class LiteracyMore extends BaseEntity {

    private long literacyId;

    @Column(length = 1000)
    private String text;
    @Column(columnDefinition = "TEXT")
    private String eyes;


    @Override
    public String toString() {
        return "Literacy{" +
                "text='" + text + '\'' +
                ", eyes='" + eyes + '\'' +
                ", id=" + id +
                '}';
    }
}
