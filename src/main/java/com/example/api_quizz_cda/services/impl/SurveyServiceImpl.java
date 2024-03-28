package com.example.api_quizz_cda.services.impl;

import com.example.api_quizz_cda.entities.Question;
import com.example.api_quizz_cda.services.SurveyService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class SurveyServiceImpl implements SurveyService {
    ObjectMapper objectMapper = new ObjectMapper();

    @Value("classpath:static/questions.json")
    Resource resourceFile;

    @Override
    public Collection<Question> getQuestions() throws IOException {
        List<Question> questionList = objectMapper.readValue(resourceFile.getFile(), new TypeReference<>(){});
        log.info(questionList.toString());
        return questionList;
    }
}
