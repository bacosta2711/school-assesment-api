package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "level")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="levelid")
    private Integer levelId;

    @Column(name="levelgrade")
    private String levelGame;

    @Column(name = "levelgraderepresentation")
    private String levelGradeRepresentation;

}
