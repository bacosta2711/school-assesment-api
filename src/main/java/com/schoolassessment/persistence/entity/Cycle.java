package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cycle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cycleid")
    private Integer cycleId;

    @Column(name="cyclename")
    private String cycleName;
}
