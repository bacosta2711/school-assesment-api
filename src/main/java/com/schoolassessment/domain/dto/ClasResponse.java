package com.schoolassessment.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClasResponse {
    private Integer level;
    private Integer user;
    private UserResponse usr;
    private LocalDate year;
    private Integer childerns;
    private String grade;
}
