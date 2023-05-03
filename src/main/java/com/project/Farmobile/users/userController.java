package com.project.Farmobile.users;

import com.project.Farmobile.users.data.DTO.LoginDTO;
import com.project.Farmobile.users.data.DTO.LoginResponseDTO;
import com.project.Farmobile.users.data.DTO.registerDTO;
import com.project.Farmobile.users.data.DTO.registerResponseDTO;
import com.project.Farmobile.users.data.help.Roles;
import com.project.Farmobile.users.data.help.status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.Farmobile.users.services.userService;

@RestController
@RequestMapping(path = "/user")
public class userController {
    private final userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    private LoginResponseDTO login(@RequestBody LoginDTO loginDTO){
        try {
            return userService.login(loginDTO);
        }
        catch (Exception e){
            return new LoginResponseDTO(status.FAILED,"", Roles.valueOf(""));
        }
    }

    @PostMapping("/register")
    private registerResponseDTO register(@RequestBody registerDTO registerDTO){
        try {
            return userService.register(registerDTO);
        }
        catch (Exception e){
            return new registerResponseDTO(status.FAILED);
        }
    }

}
