package com.schoolassessment.persistence.crud;

import com.schoolassessment.persistence.entity.Clas;
import com.schoolassessment.persistence.entity.ClasPk;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClasCrudRepository extends CrudRepository<Clas, ClasPk> {
    Optional<List<Clas>> findByClassLevel(Integer classLevel);

    Optional<List<Clas>> findByClassYear(LocalDate classYear);
}
