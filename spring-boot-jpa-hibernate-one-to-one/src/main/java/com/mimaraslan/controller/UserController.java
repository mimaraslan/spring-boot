package com.mimaraslan.controller;

import com.mimaraslan.model.User;
import com.mimaraslan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // http://localhost:8082/api/v1/users
    @GetMapping("/users")
    public List<User> getUsersAll() {
        return userRepository.findAll();
    }

    // http://localhost:8082/api/v1/users/1
    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUserFindById(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.ok().body(user);
    }
}