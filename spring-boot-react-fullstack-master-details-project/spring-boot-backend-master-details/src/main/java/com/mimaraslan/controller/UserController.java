package com.mimaraslan.controller;

import com.mimaraslan.model.User;
import com.mimaraslan.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // http://localhost:8082/api/users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // http://localhost:8082/api/users
    @PostMapping
    public User createOneUser(@RequestBody User user) {
        return userService.createOneUser(user);
    }

    // http://localhost:8082/api/users/1
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        return userService.getOneUser(userId);
    }

    // http://localhost:8082/api/users/1
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User userInfo) {
        return userService.updateOneUser(userId, userInfo);
    }


    // http://localhost:8082/api/users/1
    @DeleteMapping("/{userId}")
    public String deleteOneUser(@PathVariable Long userId) {
        return userService.deleteOneUser(userId);
    }

}