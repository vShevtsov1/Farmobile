package com.project.Farmobile.questions.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="questions")
public class questions {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idquestions")
    private Long idquestions;
    @Column(name = "name")
    private String name;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "answered")
    private Boolean answered;

}
