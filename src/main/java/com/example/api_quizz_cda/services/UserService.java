package com.example.api_quizz_cda.services;


import com.example.api_quizz_cda.entities.User;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Collection;

public interface UserService {
    Collection<User> getUsers() throws IOException;
    boolean saveUser(User user) throws IOException;
}
