package com.project.Farmobile.category.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")
public class category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idcategory")
    private Long idcategory;

    @Column(name = "categoryName")
    private String categoryName;
}
