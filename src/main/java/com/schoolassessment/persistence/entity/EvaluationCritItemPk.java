package com.schoolassessment.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EvaluationCritItemPk implements Serializable {
    @Column(name = "criterionid")
    private Integer criterionId;

    @Column(name="itemevalid")
    private Integer itemevalId;

}
