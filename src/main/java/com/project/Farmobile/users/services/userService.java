package com.project.Farmobile.users.services;

import com.project.Farmobile.config.TokenServices;
import com.project.Farmobile.users.data.DTO.LoginDTO;
import com.project.Farmobile.users.data.DTO.LoginResponseDTO;
import com.project.Farmobile.users.data.DTO.registerDTO;
import com.project.Farmobile.users.data.DTO.registerResponseDTO;
import com.project.Farmobile.users.data.help.Roles;
import com.project.Farmobile.users.data.help.status;
import com.project.Farmobile.users.data.users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.Farmobile.users.services.userRepo;

@Service
public class userService {

    private final userRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final TokenServices token;

    public userService(userRepo userRepo, PasswordEncoder passwordEncoder, TokenServices token) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.token = token;
    }

    public LoginResponseDTO login(LoginDTO loginDTO){
        users loginUsers = userRepo.findByEmail(loginDTO.getEmail());
        if(loginUsers.getActive()){
            if(passwordEncoder.matches(loginDTO.getPassword(),loginUsers.getPassword())){
                return new LoginResponseDTO(status.OK,token.generateTokenUser(loginUsers,loginDTO.getRememberMe()),loginUsers.getRole());
            }
            else {
                return new LoginResponseDTO(status.FAILED,"", Roles.valueOf(""));
            }
        }
        return new LoginResponseDTO(status.FAILED,"", Roles.valueOf(""));
    }

    public registerResponseDTO register(registerDTO registerDTO){
        users users = userRepo.save(new users(registerDTO.getName(), registerDTO.getSurname(), registerDTO.getEmail(),Roles.USER, passwordEncoder.encode(registerDTO.getPassword()), false));
        if(users == null){
            return  new registerResponseDTO(status.FAILED);
        }
        else {
            return  new registerResponseDTO(status.OK);
        }
    }
}
