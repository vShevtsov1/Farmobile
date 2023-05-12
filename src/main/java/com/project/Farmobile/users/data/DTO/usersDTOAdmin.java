package com.project.Farmobile.users.data.DTO;

import com.project.Farmobile.users.data.help.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class usersDTOAdmin {
    private Long idusers;


    private String name;


    private String surname;


    private String email;


    private Roles role;



    private Boolean active;
}
