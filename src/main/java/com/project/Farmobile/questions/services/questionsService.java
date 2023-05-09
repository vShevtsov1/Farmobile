package com.project.Farmobile.questions.services;

import com.project.Farmobile.questions.data.DTO.createQuestionsDTO;
import com.project.Farmobile.questions.data.questions;
import org.springframework.stereotype.Service;
import com.project.Farmobile.questions.services.questionsRepo;

@Service
public class questionsService {
    private final questionsRepo questionsRepo;

    public questionsService(questionsRepo questionsRepo) {
        this.questionsRepo = questionsRepo;
    }

    public questions addQuestion(createQuestionsDTO createQuestionsDTO){
        questions newQuestions = new questions(createQuestionsDTO.getName(), createQuestionsDTO.getPhonenumber(), false);
        questionsRepo.save(newQuestions);
        return newQuestions;
    }
}
