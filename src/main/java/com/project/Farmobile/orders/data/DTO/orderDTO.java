package com.project.Farmobile.orders.data.DTO;

import com.project.Farmobile.products.data.products;
import com.project.Farmobile.users.data.DTO.userDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderDTO {
    private Long idorders;
    private Date date;
    private Double summ;
    private String phoneNumber;

    private String adress;
    private userDTO userDTO;
    private List<products> products;


}
