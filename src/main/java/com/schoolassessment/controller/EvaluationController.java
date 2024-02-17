package com.schoolassessment.controller;

import com.schoolassessment.domain.dto.EvaluationResponse;
import com.schoolassessment.domain.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService service;

    @GetMapping("/all")
    public ResponseEntity<List<EvaluationResponse>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationResponse> getById(@PathVariable("id") int id){
        return service.getEvalualuationById(id)
                .map(ev-> new ResponseEntity<>(ev,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<EvaluationResponse> save(@RequestBody EvaluationResponse eval){
        return new ResponseEntity<>(service.saveEvaluation(eval),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if(service.deleteEvaluation(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
