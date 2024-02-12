package com.schoolassessment.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationRegistryDetPk implements Serializable {
    @Column(name = "registryid")
    private Integer registryId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registrydetid")
    private Integer registryDetId;


}
