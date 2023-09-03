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

    private long paragraphId;

    @Column(columnDefinition = "TEXT")
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
