package com.schoolassessment.domain.service;

import com.schoolassessment.domain.dto.EvaluationCriteriaResponse;
import com.schoolassessment.domain.repository.EvaluaitonCriteriaRepository;
import com.schoolassessment.persistence.EvaluationCriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationCriteriaService {
    @Autowired
    private EvaluaitonCriteriaRepository evaluationCriteriaRepository;

    public List<EvaluationCriteriaResponse> getAll() {return evaluationCriteriaRepository.getAll();}

    public Optional<EvaluationCriteriaResponse> getCriteriaById(int id){
        return evaluationCriteriaRepository.getCriteriaById(id);
    }

    public EvaluationCriteriaResponse saveCriteria(EvaluationCriteriaResponse eval){
        return evaluationCriteriaRepository.saveCriteria(eval);
    }

    public boolean deleteCriteria(int id ){
        return getCriteriaById(id).map(ev ->{
            evaluationCriteriaRepository.deleteCriteria(id);
            return true;
        }).orElse(false);
    }

}
