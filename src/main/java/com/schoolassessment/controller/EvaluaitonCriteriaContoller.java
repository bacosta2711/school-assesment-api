package com.schoolassessment.controller;

import com.schoolassessment.domain.dto.EvaluationCriteriaResponse;
import com.schoolassessment.domain.service.EvaluationCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluationCriteria")
public class EvaluaitonCriteriaContoller {


    @Autowired
    private EvaluationCriteriaService evalCritService;

    @GetMapping("/all")
    public ResponseEntity<List<EvaluationCriteriaResponse>> getAll(){
        return new ResponseEntity<List<EvaluationCriteriaResponse>>(evalCritService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationCriteriaResponse> getEvaluationCriteria(@PathVariable("id") int id){
        return evalCritService.getCriteriaById(id)
                .map(eval -> new ResponseEntity<>(eval, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<EvaluationCriteriaResponse> saveEvalCrit(@RequestBody EvaluationCriteriaResponse eval){
        return  new ResponseEntity<>(evalCritService.saveCriteria(eval), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEvalCrit(@PathVariable("id") int id){
        if (evalCritService.deleteCriteria(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

