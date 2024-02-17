package com.schoolassessment.controller;

import com.schoolassessment.domain.dto.IndicatorResponse;
import com.schoolassessment.domain.service.IndicatorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/indicator")
public class IndicatorController {

    @Autowired
    private IndicatorService indicatorService;

    @GetMapping("/all")
    public ResponseEntity<List<IndicatorResponse>> getAll(){
        return new ResponseEntity<List<IndicatorResponse>>(indicatorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndicatorResponse> getIndicator(@PathVariable("id") int id){
        return indicatorService.getIndicator(id)
                .map(indicator -> new ResponseEntity<>(indicator, HttpStatus.OK ))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }

    @GetMapping("/sons/{id}")
    public  ResponseEntity<List<IndicatorResponse>> getSons(@PathVariable("id") int id){
        return indicatorService.getAllSons(id)
                .map(indi -> new ResponseEntity<>(indi,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<IndicatorResponse> saveIndicator(@RequestBody IndicatorResponse indi){
        return new ResponseEntity<>(indicatorService.saveIndicator(indi),HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id  ){
        if(indicatorService.deleteIndicator(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
