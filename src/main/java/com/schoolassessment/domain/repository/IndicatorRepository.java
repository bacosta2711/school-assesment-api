package com.schoolassessment.domain.repository;

import java.util.List;
import java.util.Optional;

public interface IndicatorRepository {
    List<IndicatorRepository> getAll();
    Optional<IndicatorRepository> getIndicatorById(int id);
    List<IndicatorRepository> getAllSons();
    IndicatorRepository saveIndicator(IndicatorRepository user);
    void deleteIndicator(int id);
}
