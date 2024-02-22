package com.schoolassessment.domain.service;

import com.schoolassessment.domain.dto.EvaluationCriteriaResponse;
import com.schoolassessment.domain.dto.EvaluationResponse;
import com.schoolassessment.domain.dto.IndicatorResponse;
import com.schoolassessment.persistence.EvaluationRepository;
import com.schoolassessment.persistence.IndicatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private IndicatorRepository indicatorRepository;


    public List<EvaluationResponse> getAll(){
        return evaluationRepository.getAll();
    }
    public Optional<EvaluationResponse> getEvalualuationById(int id){
        return evaluationRepository.getEvalualuationById(id);
    }

    public EvaluationResponse saveEvaluation(EvaluationResponse eval){
        EvaluationResponse evaluaitonResult = evaluationRepository.saveEvaluation(eval);

        if(eval.equals(evaluaitonResult)) {
            System.out.println("Entro if");
        }else{
            System.out.println("Entro else");
            IndicatorResponse indicatorResponse= new IndicatorResponse();
            indicatorResponse.setEvaluation(evaluaitonResult.getId());
            indicatorResponse.setCode("C");
            indicatorResponse.setDescription(evaluaitonResult.getDescription());

            EvaluationCriteriaResponse crit = new EvaluationCriteriaResponse( );
            crit.setId(2);
            indicatorResponse.setCriteria(crit);
            indicatorRepository.saveIndicator(indicatorResponse);
        }
        return evaluaitonResult;
    }
    public boolean deleteEvaluation(int id){
        return getEvalualuationById(id).map(ev -> {
            evaluationRepository.deleteEvaluation(id);
            return true;
        }).orElse(false);
    }
}
