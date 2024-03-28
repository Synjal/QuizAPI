package com.example.api_quizz_cda.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {

    private String question;
    private HashSet<String> answers = new HashSet<>();
    private String correct_answer;

    @Override
    public String toString() {
        return "question: '" + question +
                ", answers: " + answers +
                ", correct_answer: '" + correct_answer +'\n';
    }
}
