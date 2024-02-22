package com.schoolassessment.domain.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class EvaluationResponse {
    @NotNull
    private Integer id;
    private LocalDate year;
    private LocalDate deadLine;
    private EvaluationTypeResponse type;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvaluationResponse that = (EvaluationResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(year, that.year) && Objects.equals(deadLine, that.deadLine) && Objects.equals(type, that.type) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, deadLine, type, description);
    }
}
