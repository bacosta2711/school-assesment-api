package com.schoolassessment.persistence;

import com.schoolassessment.domain.dto.EvaluationTypeResponse;
import com.schoolassessment.persistence.crud.EvaluationTypeCrudRepository;
import com.schoolassessment.persistence.entity.EvaluationType;
import com.schoolassessment.persistence.mapper.EvaluationTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EvaluationTypeRepository implements com.schoolassessment.domain.repository.EvaluationTypeRepository {

    @Autowired
    private EvaluationTypeCrudRepository evalTypeRepository;

    @Autowired
    private EvaluationTypeMapper mapper;


    @Override
    public List<EvaluationTypeResponse> getAll() {
        return mapper.toEvaluationTypes((List<EvaluationType>) evalTypeRepository.findAll());
    }

    @Override
    public Optional<EvaluationTypeResponse> getEvaluationTypeById(int id) {
        return evalTypeRepository.findById(id)
                .map(evaluationType -> mapper.toEvaluaitonType(evaluationType));
    }

    @Override
    public EvaluationTypeResponse saveEvaluationType(EvaluationTypeResponse eval) {
        EvaluationType evalResponse = mapper.evaluationTypeFromResponse(eval);
        return mapper.toEvaluaitonType(evalTypeRepository.save(evalResponse));
    }

    @Override
    public void deleteEvaluationType(int id) {
        evalTypeRepository.deleteById(id);
    }
}
