package com.schoolassessment.domain.repository;

import com.schoolassessment.persistence.entity.EvaluationCriteria;

import java.util.List;
import java.util.Optional;

public interface EvaluaitonCriteriaRepository {
    List<EvaluationCriteria> getAll();
    Optional<EvaluationCriteria> getCriteriaById(int id);

    EvaluationCriteria saveCriteria(EvaluationCriteria eval);
    void deleteCriteria(int id);
}
