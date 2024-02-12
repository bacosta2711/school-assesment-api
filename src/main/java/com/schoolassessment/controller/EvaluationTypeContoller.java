package com.schoolassessment.controller;

import com.schoolassessment.domain.dto.EvaluationTypeResponse;
import com.schoolassessment.domain.service.EvaluationTypeService;
import com.schoolassessment.persistence.EvaluationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluationTypes")
public class EvaluationTypeContoller {
    @Autowired
    private EvaluationTypeService evalTypeService;

    @GetMapping("/all")
    public ResponseEntity<List<EvaluationTypeResponse>> getAll(){
        return new ResponseEntity<>(evalTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationTypeResponse> getEvalType(@PathVariable("id") int id){
        return evalTypeService.getEvaluationTypeById(id)
                .map(evType -> new ResponseEntity<>(evType, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<EvaluationTypeResponse> saveUSer(@RequestBody EvaluationTypeResponse evalType){
        return  new ResponseEntity<>(evalTypeService.saveEvaluationType(evalType), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if(evalTypeService.deleteEvaluationType(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
