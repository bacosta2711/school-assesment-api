package com.schoolassessment.domain.repository;

import com.schoolassessment.domain.dto.IndicatorResponse;

import java.util.List;
import java.util.Optional;

public interface IndicatorRepository {
    List<IndicatorResponse> getAll();
    Optional<IndicatorResponse> getIndicatorById(int id);
    Optional<List<IndicatorResponse>> getAllSons(int id);
    IndicatorResponse saveIndicator(IndicatorResponse ind);
    void deleteIndicator(int id);
}
