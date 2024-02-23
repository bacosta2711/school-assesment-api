package com.schoolassessment.domain.service;

import com.schoolassessment.domain.dto.EvaluationRegistryResponse;
import com.schoolassessment.persistence.EvaluationRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationRegistryService {
    @Autowired
    private EvaluationRegistryRepository repository;

    public List<EvaluationRegistryResponse> getAll(){
        return repository.getAll();
    }
    public Optional<EvaluationRegistryResponse> getEvaluationRegById(int id){
        return repository.getEvaluationRegById(id);

    }
    public Optional<List<EvaluationRegistryResponse>> getAllregFromEval(int eval){
        return repository.getAllregFromEval(eval);
    }
    public EvaluationRegistryResponse saveEvaluationReg(EvaluationRegistryResponse eval){
        return repository.saveEvaluationReg(eval);
    }
    public boolean deleteRegistry(int id){
        return  getEvaluationRegById(id).map(ev -> {
            repository.deleteRegistry(id);
            return true;
        }).orElse(false);

    }

}
