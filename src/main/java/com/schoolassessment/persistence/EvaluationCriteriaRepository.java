package com.schoolassessment.persistence;

import com.schoolassessment.domain.dto.EvaluationCriteriaResponse;
import com.schoolassessment.domain.repository.EvaluaitonCriteriaRepository;
import com.schoolassessment.persistence.crud.EvaluationCriteriaCrudRepository;
import com.schoolassessment.persistence.entity.EvaluationCriteria;
import com.schoolassessment.persistence.mapper.EvaluationCriteriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EvaluationCriteriaRepository implements EvaluaitonCriteriaRepository {

    @Autowired
    private EvaluationCriteriaCrudRepository evalCritcrudrepository;

    @Autowired
    private EvaluationCriteriaMapper mapper;
    @Override

    public List<EvaluationCriteriaResponse> getAll() {
        return mapper.toEvaluationCriterias((List<EvaluationCriteria>) evalCritcrudrepository.findAll());
    }

    @Override
    public Optional<EvaluationCriteriaResponse> getCriteriaById(int id) {
        return evalCritcrudrepository.findById(id)
                .map(eva -> mapper.toEvaluationCriteria(eva));
    }

    @Override
    public EvaluationCriteriaResponse saveCriteria(EvaluationCriteriaResponse eval) {
            EvaluationCriteria evaluation = mapper.evaluatinoCriteriaFromResponse(eval);
            return mapper.toEvaluationCriteria(evalCritcrudrepository.save(evaluation));
    }

    @Override
    public void deleteCriteria(int id) {
        evalCritcrudrepository.deleteById(id);
    }
}
