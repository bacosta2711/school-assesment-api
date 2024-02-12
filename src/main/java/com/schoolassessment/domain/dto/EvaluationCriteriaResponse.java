package com.schoolassessment.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class EvaluationCriteriaResponse {
    private Integer id;
    private String description;
    private Boolean totalize;
    private List<EvaluationCriteriaItemResponse> items;
}
