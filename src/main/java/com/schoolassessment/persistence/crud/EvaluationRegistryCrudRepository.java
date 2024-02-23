package com.schoolassessment.persistence.crud;

import com.schoolassessment.persistence.entity.EvaluationRegistry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
public interface EvaluationRegistryCrudRepository extends CrudRepository<EvaluationRegistry,Integer> {

    Optional<List<EvaluationRegistry>> findByRegistryEvaluationId(Integer evaluationId);
}
