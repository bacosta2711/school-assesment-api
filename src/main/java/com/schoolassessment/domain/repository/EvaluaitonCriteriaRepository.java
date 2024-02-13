package com.schoolassessment.domain.repository;

import com.schoolassessment.domain.dto.EvaluationCriteriaResponse;
import com.schoolassessment.persistence.entity.EvaluationCriteria;

import java.util.List;
import java.util.Optional;

public interface EvaluaitonCriteriaRepository {
    List<EvaluationCriteriaResponse> getAll();
    Optional<EvaluationCriteriaResponse> getCriteriaById(int id);

    EvaluationCriteriaResponse saveCriteria(EvaluationCriteriaResponse eval);
    void deleteCriteria(int id);
}
