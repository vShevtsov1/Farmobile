package com.project.Farmobile.users.data.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDTO {

    private Long idusers;

    private String name;

    private String surname;

    private String email;
}
