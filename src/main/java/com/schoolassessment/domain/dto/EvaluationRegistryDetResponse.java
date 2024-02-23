package com.schoolassessment.domain.dto;

import lombok.Data;

@Data
public class EvaluationRegistryDetResponse {
    private Integer id;
    private EvaluationCriteriaResponse criteria;
    private Integer itemCritId;
    private Integer value;
}