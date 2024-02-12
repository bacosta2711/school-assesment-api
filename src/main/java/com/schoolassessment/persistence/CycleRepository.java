package com.schoolassessment.persistence;

import java.util.List;
import com.schoolassessment.persistence.crud.CycleCrudRepository;
import com.schoolassessment.persistence.entity.Cycle;

public class CycleRepository {
    private CycleCrudRepository cycleCrudRepository;

    public List<Cycle> getAll(){
        return (List<Cycle>) cycleCrudRepository.findAll();
    }
}
