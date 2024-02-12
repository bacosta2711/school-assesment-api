package com.schoolassessment.domain.service;

import com.schoolassessment.domain.dto.ClasResponse;
import com.schoolassessment.domain.repository.ClasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClasService {
    @Autowired
    private ClasRepository clasrepository;

    public List<ClasResponse> getAll() {return clasrepository.getAll();}

    public Optional<ClasResponse> getClassById(int level, int user, LocalDate year){return clasrepository.getClassById(level,user,year);}

    public Optional<List<ClasResponse>> getAllByLevel(int level) {return clasrepository.getAllByLevel(level);}

    public Optional<List<ClasResponse>> getAllByYear(LocalDate year){return clasrepository.getAllByYear(year);}

    public ClasResponse saveClas(ClasResponse clas){return clasrepository.saveUser(clas);}

    public boolean deleteClas(int level, int user, LocalDate year){
        return getClassById(level,user,year).map( clas ->{
            clasrepository.deleteClas(level,user,year);
            return true;
        }).orElse(false);
    }
}
