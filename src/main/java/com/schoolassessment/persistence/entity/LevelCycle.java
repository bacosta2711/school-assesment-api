package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "levelcycle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelCycle {

    @EmbeddedId
    private LevelCyclePk id;

    @OneToOne
    @JoinColumn(name = "levelid",insertable = false,updatable = false)
    private Level level;

    @OneToOne
    @JoinColumn(name = "cycleid",insertable = false,updatable = false)
    private Cycle cycle;
}
