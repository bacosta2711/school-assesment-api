package com.schoolassessment.controller;

import com.schoolassessment.domain.dto.ClasResponse;
import com.schoolassessment.domain.service.ClasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClasController {

    @Autowired
    private ClasService clasService;

    @GetMapping("/all")
    public ResponseEntity<List<ClasResponse>> getAll(){
        return new ResponseEntity<>(clasService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/item")
    public ResponseEntity<ClasResponse> getClass(@RequestBody ClasResponse clas){
        return  clasService.getClassById(clas.getLevel(), clas.getUser(), clas.getYear())
                .map(clasItem -> new ResponseEntity<>(clasItem, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<ClasResponse>> getByLevel(@PathVariable("level") int level){
        return clasService.getAllByLevel(level)
                .map(clasResponses -> new ResponseEntity<>(clasResponses,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<ClasResponse>> getByYear(@PathVariable("year") LocalDate year){
        return clasService.getAllByYear(year)
                .map(clasResponses -> new ResponseEntity<>(clasResponses,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ClasResponse> saveClas(@RequestBody ClasResponse clas){
        return  new ResponseEntity<>(clasService.saveClas(clas),HttpStatus.CREATED);

    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteClas(@RequestBody ClasResponse clas){
        if(clasService.deleteClas(clas.getLevel(),clas.getUser(),clas.getYear())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
