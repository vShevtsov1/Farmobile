package com.project.Farmobile.users.services;

import com.project.Farmobile.aws.S3Service;
import com.project.Farmobile.config.TokenServices;
import com.project.Farmobile.mail.emailController;
import com.project.Farmobile.users.data.DTO.*;
import com.project.Farmobile.users.data.help.Roles;
import com.project.Farmobile.users.data.help.status;
import com.project.Farmobile.users.data.users;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.Farmobile.users.services.userRepo;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class userService {

    private final userRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final TokenServices tokenServices;
    private final emailController emailController;
    private final ModelMapper modelMapper;

    public userService(userRepo userRepo, PasswordEncoder passwordEncoder, TokenServices tokenServices, emailController emailController,ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.tokenServices = tokenServices;
        this.emailController = emailController;
        this.modelMapper = modelMapper;
    }

    public LoginResponseDTO login(LoginDTO loginDTO) throws FileNotFoundException {
        users loginUsers = userRepo.findByEmail(loginDTO.getEmail());
        if(loginUsers.getActive()){
            if(passwordEncoder.matches(loginDTO.getPassword(),loginUsers.getPassword())){
                return new LoginResponseDTO(status.OK,tokenServices.generateTokenUser(loginUsers,loginDTO.getRememberMe()),loginUsers.getRole());
            }
            else {
                return new LoginResponseDTO(status.FAILED,"", Roles.UNDEFINED);
            }
        }
        return new LoginResponseDTO(status.FAILED,"", Roles.UNDEFINED);
    }

    public registerResponseDTO register(registerDTO registerDTO){
        users users = userRepo.save(new users(registerDTO.getName(), registerDTO.getSurname(), registerDTO.getEmail(),Roles.USER, passwordEncoder.encode(registerDTO.getPassword()), false));
        if(users == null){
            return  new registerResponseDTO(status.FAILED);
        }
        else {
            emailController.SendConfirmationMail(tokenServices.generateTokenActivation(users),users);
            return  new registerResponseDTO(status.OK);
        }
    }

    public status activation(String token){
        if(tokenServices.validateTokenActivation(token)){
            users activationUsers = userRepo.findByEmail(tokenServices.getMailActivation(token));
            if(activationUsers == null){
                return status.FAILED;
            }
            else {
                if(activationUsers.getActive()){
                    return status.FAILED;
                }
                else {
                    activationUsers.setActive(true);
                    userRepo.save(activationUsers);
                    return status.OK;
                }
            }
        }
        else {
            return status.FAILED;
        }
    }
    public status forgotPassword(String email){
        users forgotPasswordUser = userRepo.findByEmail(email);
            if(forgotPasswordUser == null){
                return status.FAILED;
            }
            else {
                emailController.SendResetPasswordMail(tokenServices.generateTokenActivation(forgotPasswordUser),forgotPasswordUser);
                return status.OK;
            }
        }
    public status resetPassword(String token, resetPasswordDTO resetPasswordDTO){
        users resetPasswordUser = userRepo.findByEmail(tokenServices.getMailActivation(token));
        if(resetPasswordUser == null){
            return status.FAILED;
        }
        else {
            resetPasswordUser.setPassword(passwordEncoder.encode(resetPasswordDTO.getPassword()));
            userRepo.save(resetPasswordUser);
            return status.OK;
        }
    }
    public userDTO getMyInfo(String mail){
        users users = userRepo.findByEmail(mail);
        if(users == null){
            return null;
        }
        else {
            return modelMapper.map(users,userDTO.class);
        }
    }

}
