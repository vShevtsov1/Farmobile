package com.project.Farmobile.questions;

import com.project.Farmobile.questions.data.DTO.createQuestionsDTO;
import com.project.Farmobile.questions.data.questions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.Farmobile.questions.services.questionsService;

@RestController
@RequestMapping(path = "/questions")
public class questionsController {
    private final questionsService questionsService;

    public questionsController(questionsService questionsService) {
        this.questionsService = questionsService;
    }

    @PostMapping("/create")
    public questions createQuestion(@RequestBody createQuestionsDTO createQuestionsDTO){
        return questionsService.addQuestion(createQuestionsDTO);
    }
}
