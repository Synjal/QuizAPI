package com.example.api_quizz_cda.services.impl;

import com.example.api_quizz_cda.entities.User;
import com.example.api_quizz_cda.services.UserService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    ObjectMapper objectMapper = new ObjectMapper();

    @Value("classpath:static/leaderboards.json")
    Resource resourceFile;

    @Override
    public Collection<User> getUsers() throws IOException {
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        return objectMapper.readValue(resourceFile.getFile(), new TypeReference<>() {});
    }

    @Override
    public boolean saveUser(@RequestBody User user) throws IOException {
        try {
            Collection<User> users = getUsers();
            users.add(user);
            objectMapper.writeValue(resourceFile.getFile(), users);
            log.info("User successfully added");

            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return false;
    }
}
