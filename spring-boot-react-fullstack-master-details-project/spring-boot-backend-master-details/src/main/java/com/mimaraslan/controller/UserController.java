package com.mimaraslan.controller;

import com.mimaraslan.model.User;
import com.mimaraslan.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    // http://localhost:8082/api/users
    @GetMapping
    public List<User> getAllUsers() {
        logger.debug("Get all users.");
        return userRepository.findAll();
    }

    // http://localhost:8082/api/users
    @PostMapping
    public User createUser(@RequestBody User user) {
        logger.debug("Add one user.");
        return userRepository.save(user);
    }

    // http://localhost:8082/api/users/1
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        logger.debug("Get one user.");
        return userRepository.findById(userId).orElse(null);
    }

    // http://localhost:8082/api/users/1
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User userInfo) {
        logger.debug("Update one user.");
        Optional<User> userFound = userRepository.findById(userId);
        if (userFound.isPresent()) {
            User userUpdated = userFound.get();
            userUpdated.setUserName(userInfo.getUserName());
            userUpdated.setPassword(userInfo.getPassword());
            userRepository.save(userUpdated);
            return userUpdated;
        } else {
            return null;
        }
    }


    // http://localhost:8082/api/users/1
    @DeleteMapping("/{userId}")
    public String deleteOneUser(@PathVariable Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            logger.debug("Delete one user.");
            return "Deleted one user";
        } else {
            return null;
        }
    }

}
