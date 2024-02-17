package com.schoolassessment.persistence.crud;

import com.schoolassessment.persistence.entity.Indicator;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IndicatorCrudRepository extends CrudRepository<Indicator,Integer> {
    Optional<List<Indicator>> findByFatherOrderByIndicatorCode(Integer idFather);
}
