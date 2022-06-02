package com.mimaraslan.service;

import com.mimaraslan.model.User;
import com.mimaraslan.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        logger.debug("Get all users.");
        return userRepository.findAll();
    }

    public User createOneUser(@RequestBody User user) {
        logger.debug("Add one user.");
        return userRepository.save(user);
    }

    public User getOneUser(@PathVariable Long userId) {
        logger.debug("Get one user.");
        return userRepository.findById(userId).orElse(null);
    }

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