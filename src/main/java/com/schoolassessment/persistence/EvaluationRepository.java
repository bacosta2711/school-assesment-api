package com.schoolassessment.persistence;

import com.schoolassessment.domain.dto.EvaluationResponse;
import com.schoolassessment.persistence.crud.EvaluationCrudRepository;
import com.schoolassessment.persistence.entity.Evaluation;
import com.schoolassessment.persistence.mapper.EvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EvaluationRepository implements com.schoolassessment.domain.repository.EvaluationRepository {

    @Autowired
    private EvaluationCrudRepository evaluationCrudRepository;

    @Autowired
    private EvaluationMapper mapper;

    @Override
    public List<EvaluationResponse> getAll() {
        return mapper.toEvaluations((List<Evaluation>) evaluationCrudRepository.findAll()) ;
    }

    @Override
    public Optional<EvaluationResponse> getEvalualuationById(int id) {
        return evaluationCrudRepository.findById(id)
                .map(ev -> mapper.toEvaluation(ev));
    }

    @Override
    public EvaluationResponse saveEvaluation(EvaluationResponse eval) {

        Evaluation evalEntity = mapper.evaluationFromResponse(eval);
        evalEntity.setEvaluationTypeId(eval.getType().getId());
        System.out.println(eval.toString());
        System.out.println(evalEntity.toString());
        return mapper.toEvaluation(evaluationCrudRepository.save(evalEntity));
    }

    @Override
    public void deleteEvaluation(int id) {
        evaluationCrudRepository.deleteById(id);

    }
}
