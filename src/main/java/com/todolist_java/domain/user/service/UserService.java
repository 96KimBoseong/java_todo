package com.todolist_java.domain.user.service;

import com.todolist_java.domain.user.dto.SignUpRequestDTO;
import com.todolist_java.domain.user.dto.UserResponseDTO;

public interface UserService {
    public UserResponseDTO signUp(SignUpRequestDTO signUpRequestDTO);
}
