package com.dbbyte.quizzes.controllers;

import com.dbbyte.quizzes.models.Question;
import com.dbbyte.quizzes.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author adrian on 12/10/2017
 * @project app-quizzes
 */

@RestController
class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestions(@PathVariable String surveyId) {
        return surveyService.retrieveQuestions(surveyId);
    }

    @GetMapping(path = "/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveQuestion(@PathVariable String surveyId,
                                     @PathVariable String questionId) {
        return surveyService.retrieveQuestion(surveyId, questionId);
    }

    @PostMapping("/surveys/{surveyId}/questions")
    ResponseEntity<?> add(@PathVariable String surveyId,
                          @RequestBody Question question) {

        Question createQuestion = surveyService.addQuestion(surveyId, question);

        if (createQuestion == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createQuestion.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

}