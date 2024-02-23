package com.schoolassessment.domain.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EvaluationRegistryResponse {
    private Integer id;
    private Integer evaluation;
    private String status;
    private LocalDate statusDate;
    private Integer level;
    private Integer user;
    private Integer year;
    private ClasResponse clas;
    private List<EvaluationRegistryDetResponse> det;
}
