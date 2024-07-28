package com.todolist_java.domain.user.service;

import com.todolist_java.domain.user.dto.LoginRequestDTO;
import com.todolist_java.domain.user.dto.LoginResponseDTO;
import com.todolist_java.domain.user.dto.SignUpRequestDTO;
import com.todolist_java.domain.user.dto.UserResponseDTO;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
    public UserResponseDTO signUp(SignUpRequestDTO signUpRequestDTO);
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO, HttpServletResponse response);
}
