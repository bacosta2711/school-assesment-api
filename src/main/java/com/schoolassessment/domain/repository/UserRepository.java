package com.schoolassessment.domain.repository;

import com.schoolassessment.domain.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserResponse> getAll();
    Optional<UserResponse> getUserById(int id);
    List<UserResponse> getAllEnabled();
    UserResponse saveUser(UserResponse user);
    void deleteUser(int id);
}
