package com.schoolassessment.domain.service;

import com.schoolassessment.domain.dto.IndicatorResponse;
import com.schoolassessment.persistence.IndicatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndicatorService {

    @Autowired
    private IndicatorRepository indicatorRepository;

    public List<IndicatorResponse> getAll(){ return  indicatorRepository.getAll();}
    public Optional<IndicatorResponse> getIndicator(int id){return  indicatorRepository.getIndicatorById(id);}
    public Optional<List<IndicatorResponse>> getAllSons(int id){return  indicatorRepository.getAllSons(id);}
    public IndicatorResponse saveIndicator(IndicatorResponse ind){return  indicatorRepository.saveIndicator(ind);}
    public boolean deleteIndicator(int id){
        return getIndicator(id).map(indicatorResponse -> {
            indicatorRepository.deleteIndicator(id);
            return true;
        }).orElse(false);
    }
}
