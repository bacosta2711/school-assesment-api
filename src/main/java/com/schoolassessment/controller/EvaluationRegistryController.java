package com.schoolassessment.controller;

import com.schoolassessment.domain.dto.EvaluationRegistryResponse;
import com.schoolassessment.domain.service.EvaluationRegistryService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/evaluationReg")
public class EvaluationRegistryController {

    @Autowired
    private EvaluationRegistryService service;

    @GetMapping("/all") public ResponseEntity<List<EvaluationRegistryResponse>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") public ResponseEntity<EvaluationRegistryResponse> getById(@PathVariable("id") int id){
        return service.getEvaluationRegById(id)
                .map(reg ->  new ResponseEntity<>(reg, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/evaluation/{id}") public ResponseEntity<List<EvaluationRegistryResponse>> getfromEval(@PathVariable("id") int id){
        return service.getAllregFromEval(id)
                .map(list -> new ResponseEntity<>(list,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save") public ResponseEntity<EvaluationRegistryResponse> save(@RequestBody EvaluationRegistryResponse eval){
        return new ResponseEntity<>(service.saveEvaluationReg(eval), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}") public ResponseEntity delete(@PathVariable("id") int id){
        if(service.deleteRegistry(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
