package com.schoolassessment.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelCyclePk implements Serializable {
    @Column(name = "levelid")
    private Integer levelId;

    @Column(name = "cycleid")
    private Integer cycleId;

    @Column(name = "levelcycleyear")
    private LocalDate levelCycleYear;
}
