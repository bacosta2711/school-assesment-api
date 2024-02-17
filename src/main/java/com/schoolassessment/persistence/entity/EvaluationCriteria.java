package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import javax.print.attribute.standard.MediaSize;

@Data
@Table(name = "evaluationcriteria")
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class EvaluationCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "criterionid")
    private Integer criterionId;

    @Column(name = "criteriondesc")
    private String criterionDesc;

    @Column(name = "criteriontotalize")
    private Boolean criterionTotalize;

    @OneToMany(mappedBy = "evaluationCriteria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluationCritItem> items;

  @OneToMany(mappedBy = "evaluationCriterians")
    private List<Indicator> indicators;


}
