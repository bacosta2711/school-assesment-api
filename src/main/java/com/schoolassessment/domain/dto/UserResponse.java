package com.schoolassessment.domain.dto;

import lombok.Data;

@Data
public class UserResponse {
    private int id;
    private String name;
    private String mail;
    private String role;
    private Boolean enabled;

}
