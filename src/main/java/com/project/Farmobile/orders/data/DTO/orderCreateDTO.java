package com.project.Farmobile.orders.data.DTO;

import com.project.Farmobile.products.data.products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderCreateDTO {

    private Double summ;

    private String phoneNumber;

    private String adress;
    private List<products> products;
}
