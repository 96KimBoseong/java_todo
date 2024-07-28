package com.todolist_java.domain.user.service;

import com.todolist_java.domain.user.dto.LoginRequestDTO;
import com.todolist_java.domain.user.dto.LoginResponseDTO;
import com.todolist_java.domain.user.dto.SignUpRequestDTO;
import com.todolist_java.domain.user.dto.UserResponseDTO;
import com.todolist_java.domain.user.model.User;
import com.todolist_java.domain.user.repository.UserRepository;
import com.todolist_java.infra.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    public UserServiceImpl(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }


    @Override
    public UserResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        if(userRepository.existsByUsername(signUpRequestDTO.getUsername())){
            throw new IllegalArgumentException("Username already exists");
        }
        User user = signUpRequestDTO.toUser();
        userRepository.save(user);
        return UserResponseDTO.formUser(user);
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO, HttpServletResponse response) {
        User user = userRepository.findByUsername(loginRequestDTO.getUsername()).orElseThrow(()-> new IllegalArgumentException("UserId 오류"));
        if (user.getPassword().equals(loginRequestDTO.getPassword())){
            String token = jwtUtil.createToken(user.getUsername(), user.getRole());
            jwtUtil.addJwtToCookie(token, response);
            return LoginResponseDTO.formUserWithToken(user.getId(),user.getNickname(),user.getUsername(),token);
        }else {
            throw new IllegalArgumentException("Wrong password");
        }
    }

}
