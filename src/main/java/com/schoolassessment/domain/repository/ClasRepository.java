package com.schoolassessment.domain.repository;

import com.schoolassessment.domain.dto.ClasResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClasRepository {
    List<ClasResponse> getAll();
    Optional<ClasResponse> getClassById(int level, int user, LocalDate year);

    Optional<List<ClasResponse>> getAllByLevel(int level);

    Optional<List<ClasResponse>> getAllByYear(LocalDate year);
    ClasResponse saveUser(ClasResponse clas);
    void deleteClas(int level, int user, LocalDate year);
}
