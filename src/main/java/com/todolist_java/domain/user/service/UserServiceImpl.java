package com.todolist_java.domain.user.service;

import com.todolist_java.domain.user.dto.SignUpRequestDTO;
import com.todolist_java.domain.user.dto.UserResponseDTO;
import com.todolist_java.domain.user.model.User;
import com.todolist_java.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        if(userRepository.existsByUsername(signUpRequestDTO.getUsername())){
            throw new IllegalArgumentException("Username already exists");
        }
        User user = signUpRequestDTO.toUser();
        userRepository.save(user);
        return UserResponseDTO.forUser(user);
    }
}
