package com.example.api_quizz_cda.services;

import com.example.api_quizz_cda.entities.Question;

import java.io.IOException;
import java.util.Collection;

public interface SurveyService {

    Collection<Question> getQuestions() throws IOException;
}
