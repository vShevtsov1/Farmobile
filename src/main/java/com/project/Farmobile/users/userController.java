package com.project.Farmobile.users;

import com.project.Farmobile.users.data.DTO.*;
import com.project.Farmobile.users.data.help.Roles;
import com.project.Farmobile.users.data.help.status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
            return new LoginResponseDTO(status.FAILED,"", Roles.UNDEFINED);
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
    @GetMapping("/activation")
    private status activation(@RequestParam("token")String token){
        return userService.activation(token);
    }

    @PostMapping("/forgot-password/{email}")
    private status forgotPassword(@PathVariable("email")String email){
        try {
            return userService.forgotPassword(email);
        }
        catch (Exception e){
            return status.FAILED;
        }
    }
    @PostMapping("/reset-password")
    private status resetPassword(@RequestParam("token")String token,@RequestBody resetPasswordDTO resetPasswordDTO){
        try {
            return userService.resetPassword(token,resetPasswordDTO);
        }
        catch (Exception e){
            e.printStackTrace();
            return status.FAILED;
        }
    }
}
