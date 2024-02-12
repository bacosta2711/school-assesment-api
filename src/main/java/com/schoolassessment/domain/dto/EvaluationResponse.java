package com.schoolassessment.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EvaluationResponse {
    private Integer id;
    private LocalDate year;
    private LocalDate deadLine;
    private EvaluationTypeResponse type;
    private String description;

}
