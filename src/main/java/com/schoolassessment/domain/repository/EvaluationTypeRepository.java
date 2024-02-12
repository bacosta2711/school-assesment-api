package com.schoolassessment.domain.repository;

import com.schoolassessment.domain.dto.EvaluationTypeResponse;

import java.util.List;
import java.util.Optional;

public interface EvaluationTypeRepository {
    List<EvaluationTypeResponse> getAll();
    Optional<EvaluationTypeResponse> getEvaluationTypeById(int id);
    EvaluationTypeResponse saveEvaluationType(EvaluationTypeResponse eval);
    void deleteEvaluationType(int id);
}
