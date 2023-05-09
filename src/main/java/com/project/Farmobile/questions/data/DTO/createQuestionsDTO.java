package com.project.Farmobile.questions.data.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class createQuestionsDTO {
    private String name;

    private String phonenumber;
}
