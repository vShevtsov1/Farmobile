package com.project.Farmobile.questions.services;

import com.project.Farmobile.questions.data.questions;
import org.springframework.data.repository.CrudRepository;

public interface questionsRepo extends CrudRepository<questions, Long> {
}
