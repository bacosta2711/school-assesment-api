package com.schoolassessment.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evaluationregistry")
public class EvaluationRegistry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registryid")
    private Integer registryId;

    @Column(name = "registryevaluation")
    private Integer registryEvaluationId;

    @Column(name ="registrystatus" )
    private String registryStatus;

    @Column(name = "registrystatusdate")
    private LocalDate registryStatusDate;

    @Column(name = "registryclasslevel")
    private Integer registryClassLevel;

    @Column(name = "registryclassuser")
    private Integer registryClassUser;

    @Column(name = "registryclassyear")
    private LocalDate registryClassYear;

    @ManyToOne
    @JoinColumn(name = "registryevaluation",insertable = false, updatable = false)
    private Evaluation registryEvaluation;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "classlevel",insertable = false,updatable = false),
            @JoinColumn(name = "classuser",insertable = false,updatable = false),
            @JoinColumn(name = "classyear",insertable = false,updatable = false)
    })
    private Clas clas;



    @OneToMany(mappedBy = "registry")
    private List<EvaluationRegistryDet> evaluationRegistryDetList;

}
