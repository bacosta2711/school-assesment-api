package com.schoolassessment.domain.repository;

import com.schoolassessment.domain.dto.EvaluationRegistryResponse;

import java.util.List;
import java.util.Optional;

public interface EvaluaitonRegistryRepository {
    List<EvaluationRegistryResponse> getAll();
    Optional<EvaluationRegistryResponse> getEvaluationRegById(int id);

    List<EvaluationRegistryResponse> getAllregFromEval(int eval);
    EvaluationRegistryResponse saveEvaluationReg(EvaluationRegistryResponse eval);
    void deleteRegistry(int id);
}
