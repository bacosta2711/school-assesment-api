package com.schoolassessment.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasPk implements Serializable {
    private Integer classLevel;
    private Integer classUser;
    private LocalDate classYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClasPk clasPk = (ClasPk) o;
        return Objects.equals(classLevel, clasPk.classLevel) && Objects.equals(classUser, clasPk.classUser) && Objects.equals(classYear, clasPk.classYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classLevel, classUser, classYear);
    }
}
