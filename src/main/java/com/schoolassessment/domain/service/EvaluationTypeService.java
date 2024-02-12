package com.schoolassessment.domain.service;

import com.schoolassessment.domain.dto.EvaluationTypeResponse;
import com.schoolassessment.domain.repository.EvaluationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationTypeService {
    @Autowired
    private EvaluationTypeRepository evaluationTypeRepository;

    public List<EvaluationTypeResponse> getAll(){
        return evaluationTypeRepository.getAll();
    }
    public Optional<EvaluationTypeResponse> getEvaluationTypeById(int id){
        return evaluationTypeRepository.getEvaluationTypeById(id);
    }
    public EvaluationTypeResponse saveEvaluationType(EvaluationTypeResponse eval){
        return evaluationTypeRepository.saveEvaluationType(eval);
    }
    public boolean deleteEvaluationType(int id){
        return getEvaluationTypeById(id).map(evalType -> {
            evaluationTypeRepository.deleteEvaluationType(id);
            return true;
        }).orElse(false);
    }




}
