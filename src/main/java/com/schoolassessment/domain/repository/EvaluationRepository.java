package com.schoolassessment.domain.repository;

import com.schoolassessment.domain.dto.EvaluationCriteriaResponse;
import com.schoolassessment.domain.dto.EvaluationResponse;

import java.util.List;
import java.util.Optional;

public interface EvaluationRepository {

    List<EvaluationResponse> getAll();
    Optional<EvaluationResponse> getEvalualuationById(int id);

    EvaluationResponse saveEvaluation(EvaluationResponse eval);
    void deleteEvaluation(int id);
}
