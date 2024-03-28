package com.example.api_quizz_cda.controller;

import com.example.api_quizz_cda.entities.Question;
import com.example.api_quizz_cda.services.impl.SurveyServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;

@RestController
public class SurveyController {

    private final SurveyServiceImpl surveyService;

    public SurveyController(SurveyServiceImpl surveyService) {
        this.surveyService = surveyService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/surveys")
    public Collection<Question> getSurveys() throws IOException {
        return surveyService.getQuestions();
    }
}
