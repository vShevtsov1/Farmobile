package com.project.Farmobile.products.data.DTO;

import com.project.Farmobile.category.data.category;
import com.project.Farmobile.photo.data.photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productsSaveDTO {
    private String name;
    private Double price;
    private Integer quantity;
    private String fullDescription;
    private String productSpecs;
    private category category;
    private photo photo;
}
