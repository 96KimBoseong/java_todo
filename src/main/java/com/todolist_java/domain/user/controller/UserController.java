package com.todolist_java.domain.user.controller;

import com.todolist_java.domain.user.dto.SignUpRequestDTO;
import com.todolist_java.domain.user.dto.UserResponseDTO;
import com.todolist_java.domain.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signUp")
    public ResponseEntity<UserResponseDTO> singUp(@RequestBody SignUpRequestDTO requestDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.signUp(requestDTO));
    }
}
