package com.schoolassessment.persistence;

import com.schoolassessment.domain.dto.EvaluationRegistryResponse;
import com.schoolassessment.domain.repository.EvaluaitonRegistryRepository;
import com.schoolassessment.persistence.crud.EvaluationRegistryCrudRepository;
import com.schoolassessment.persistence.entity.EvaluationCriteria;
import com.schoolassessment.persistence.entity.EvaluationRegistry;
import com.schoolassessment.persistence.mapper.EvaluationRegistryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EvaluationRegistryRepository implements EvaluaitonRegistryRepository {

    @Autowired
    private EvaluationRegistryMapper maper;

    @Autowired
    private EvaluationRegistryCrudRepository evaluationRegistryCrudRepository;


    @Override
    public List<EvaluationRegistryResponse> getAll() {
        return maper.toEvaluationsRegs((List<EvaluationRegistry>) evaluationRegistryCrudRepository.findAll());
    }

    @Override
    public Optional<EvaluationRegistryResponse> getEvaluationRegById(int id) {
        return evaluationRegistryCrudRepository.findById(id)
                .map(eval -> maper.toEvaluationReg(eval));
    }

    @Override
    public Optional<List<EvaluationRegistryResponse>> getAllregFromEval(int eval) {
        return evaluationRegistryCrudRepository.findByRegistryEvaluationId(eval)
                .map(ev -> maper.toEvaluationsRegs(ev));
    }

    @Override
    public EvaluationRegistryResponse saveEvaluationReg(EvaluationRegistryResponse eval) {
        EvaluationRegistry evaluation = maper.EvaluationfromResponse(eval);
        return maper.toEvaluationReg(evaluationRegistryCrudRepository.save(evaluation));
    }

    @Override
    public void deleteRegistry(int id) {
        evaluationRegistryCrudRepository.deleteById(id);
    }
}
