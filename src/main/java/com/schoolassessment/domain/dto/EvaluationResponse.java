package com.schoolassessment.domain.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
public class EvaluationResponse {
    @NotNull
    private Integer id;
    private LocalDate year;
    private LocalDate deadLine;
    private EvaluationTypeResponse type;
    private String description;

}
