package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evaluationregistrydet")
public class EvaluationRegistryDet {
    @EmbeddedId
    private EvaluationRegistryDetPk id;

    @Column(name = "registrydetcriterionid")
    private Integer registryDetCriterionId;

    @Column(name = "registrydetitemevalid")
    private Integer registryDetItemeValId;

    @Column(name = "registrydetvalue")
    private Integer registryDetValue;

    @ManyToOne
    @JoinColumn(name = "registryid",insertable = false, updatable = false)
    private EvaluationRegistry registry;

}
