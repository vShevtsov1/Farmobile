package com.project.Farmobile.users.data.DTO;

import com.project.Farmobile.users.data.help.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private status status;
    private String jwt;
    private Roles roles;
}
