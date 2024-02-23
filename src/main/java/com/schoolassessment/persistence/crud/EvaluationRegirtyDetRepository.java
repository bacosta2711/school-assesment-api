package com.schoolassessment.persistence.crud;

import com.schoolassessment.persistence.entity.EvaluationRegistryDet;
import com.schoolassessment.persistence.entity.EvaluationRegistryDetPk;
import org.springframework.data.repository.CrudRepository;

public interface EvaluationRegirtyDetRepository extends CrudRepository<EvaluationRegistryDet, EvaluationRegistryDetPk> {
}
