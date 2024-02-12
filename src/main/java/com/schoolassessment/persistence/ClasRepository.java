package com.schoolassessment.persistence;

import com.schoolassessment.domain.dto.ClasResponse;
import com.schoolassessment.persistence.crud.ClasCrudRepository;
import com.schoolassessment.persistence.entity.Clas;
import com.schoolassessment.persistence.entity.ClasPk;
import com.schoolassessment.persistence.mapper.ClasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ClasRepository implements com.schoolassessment.domain.repository.ClasRepository {
    @Autowired
    private ClasCrudRepository clasCrudRepository;

    @Autowired
    private ClasMapper mapper;

    @Override
    public List<ClasResponse> getAll() {
        return mapper.toClasses((List<Clas>) clasCrudRepository.findAll());
    }

    @Override
    public Optional<ClasResponse> getClassById(int level, int user, LocalDate year) {
        ClasPk id= new ClasPk(level,user,year);

        return clasCrudRepository.findById(id)
                .map(clas -> mapper.toClass(clas));
    }

    @Override
    public Optional<List<ClasResponse>> getAllByLevel(int level) {
        return clasCrudRepository.findByClassLevel(level)
                .map(clas -> mapper.toClasses(clas));
    }

    @Override
    public Optional<List<ClasResponse>> getAllByYear(LocalDate year) {
        return clasCrudRepository.findByClassYear(year)
                .map(clas -> mapper.toClasses(clas));
    }

    @Override
    public ClasResponse saveUser(ClasResponse clas) {
        Clas clase = mapper.clasFromResponse(clas);
        return mapper.toClass(clasCrudRepository.save(clase));
    }

    @Override
    public void deleteClas(int level, int user, LocalDate year) {
        ClasPk id= new ClasPk(level,user,year);
        clasCrudRepository.deleteById(id);

    }
}
