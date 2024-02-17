package com.schoolassessment.persistence;

import com.schoolassessment.domain.dto.IndicatorResponse;
import com.schoolassessment.persistence.crud.IndicatorCrudRepository;
import com.schoolassessment.persistence.entity.Indicator;
import com.schoolassessment.persistence.mapper.IndicatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IndicatorRepository implements com.schoolassessment.domain.repository.IndicatorRepository {
    @Autowired
    private IndicatorCrudRepository indicatorCrudRepository;

    @Autowired
    private IndicatorMapper mapper;

    @Override
    public List<IndicatorResponse> getAll() {
        return mapper.toIndicators((List<Indicator>)indicatorCrudRepository.findAll());
    }

    @Override
    public Optional<IndicatorResponse> getIndicatorById(int id) {
        return indicatorCrudRepository.findById(id)
                .map(indicator -> mapper.toIndicator(indicator));
    }

    @Override
    public Optional<List<IndicatorResponse>> getAllSons(int id) {
        return indicatorCrudRepository.findByFatherOrderByIndicatorCode(id)
                .map(indi -> mapper.toIndicators(indi));
    }

    @Override
    public IndicatorResponse saveIndicator(IndicatorResponse ind) {
        Indicator indicator = mapper.indicatorFromResponse(ind);
        return  mapper.toIndicator(indicatorCrudRepository.save(indicator ));
    }

    @Override
    public void deleteIndicator(int id) {
        indicatorCrudRepository.deleteById(id);
    }
}
