package com.schoolassessment.domain.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EvaluationRegistryResponse {
    private Integer id;
    private EvaluationResponse evaluation;
    private String status;
    private LocalDate statusDate;
    private ClasResponse clas;
    private List<EvaluationRegistryDetResponse> det;
}
