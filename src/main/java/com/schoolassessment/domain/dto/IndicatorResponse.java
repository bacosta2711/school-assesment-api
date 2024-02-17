package com.schoolassessment.domain.dto;

import lombok.Data;

@Data
public class IndicatorResponse {
    private Integer id;
    private String code;
    private String description;
    private EvaluationCriteriaResponse criteria;
    private Integer evaluation;
    private Integer father;
}
