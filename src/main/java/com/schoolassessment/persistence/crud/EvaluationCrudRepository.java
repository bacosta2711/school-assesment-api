package com.schoolassessment.persistence.crud;

import com.schoolassessment.persistence.entity.Evaluation;
import org.springframework.data.repository.CrudRepository;

public interface EvaluationCrudRepository extends CrudRepository<Evaluation, Integer> {
}
