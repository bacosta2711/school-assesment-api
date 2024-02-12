package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evaluationcrititem")
public class EvaluationCritItem {
    @EmbeddedId
    private EvaluationCritItemPk id;

    @Column(name = "itemdesc")
    private String itemDesc;

    @Column(name = "itemrep")
    private String itemRep;

    @ManyToOne
    @JoinColumn(name = "criterionid",insertable = false,updatable = false)
    private EvaluationCriteria evaluationCriteria;
}
