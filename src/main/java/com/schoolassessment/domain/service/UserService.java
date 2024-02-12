package com.schoolassessment.domain.service;

import com.schoolassessment.domain.dto.UserResponse;
import com.schoolassessment.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserResponse> getAll(){
        return userRepository.getAll();
    }

    public Optional<UserResponse> getUser(int id){
        return userRepository.getUserById(id);
    }

    public List<UserResponse> getAllEnabled(){
        return userRepository.getAllEnabled();
    }

    public UserResponse saveUser(UserResponse user){
        return userRepository.saveUser(user);
    }

    public boolean deleteUser (int id){
        return getUser(id).map(usr -> {
            userRepository.deleteUser(id);
            return true;
        }).orElse(false);
    }

}
