package com.schoolassessment.controller;

import com.schoolassessment.domain.dto.UserResponse;
import com.schoolassessment.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") int id){
        return userService.getUser(id)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
@PostMapping("/save")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserResponse usr){
        return new ResponseEntity<>(userService.saveUser(usr), HttpStatus.CREATED);
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id){
        if (userService.deleteUser(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
