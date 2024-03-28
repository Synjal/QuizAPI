package com.example.api_quizz_cda.controller;

import com.example.api_quizz_cda.entities.User;
import com.example.api_quizz_cda.services.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RestController
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users")
    public Collection<User> getUsers() throws IOException {
        return userService.getUsers();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@Validated @RequestBody User user) throws IOException {
        return userService.saveUser(user)
                ? ResponseEntity.ok(user)
                : ResponseEntity.badRequest().build();
    }
}
