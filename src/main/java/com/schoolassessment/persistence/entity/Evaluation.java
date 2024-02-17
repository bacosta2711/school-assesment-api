package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluationid")
    private Integer evaluationId;

    @Column(name = "evaluationyear")
    private LocalDate evaluationYear;

    @Column(name = "evaluationdeadline")
    private LocalDate evaluationDeadLine;

    @Column(name = "evaluationtype")
    private Integer evaluationTypeId;

    @Column(name = "evaluationdesc")
    private String evaluationDesc;

    @ManyToOne
    @JoinColumn(name = "evaluationtype",insertable = false, updatable = false)
    private EvaluationType evaluationType;

    @OneToMany(mappedBy = "registryEvaluation")
    private List<EvaluationRegistry> evaluationRegistryList;


}
