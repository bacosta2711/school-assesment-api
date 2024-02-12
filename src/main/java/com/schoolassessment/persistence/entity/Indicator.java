package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "indicator")
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "indicatorid")
    private Integer indicatorId;

    @Column(name = "indicatorcode")
    private String indicatorCode;

    @Column(name = "indicatordesc")
    private String indicatorDesc;

    @Column(name = "indicatorcriteria")
    private Integer indicatorCriteriaId;

    @Column(name = "indicatorevaluation")
    private Integer indicatorEvaluation;

    @Column(name = "inicatorfather")
    private Integer inicatorFather;

   @ManyToOne
    @JoinColumn(name = "indicatorcriteria", insertable = false, updatable = false)
    private EvaluationCriteria evaluationCriterians;

    @OneToOne
    @JoinColumn(name = "indicatorid",insertable = false,updatable = false)
    private Indicator indicatorFather;

    @OneToOne
    @JoinColumn(name = "evaluationId", insertable = false,updatable = false)
    private Evaluation indicatorEval;

}
