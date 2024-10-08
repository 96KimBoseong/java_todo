package com.todolist_java.domain.user.controller;

import com.todolist_java.domain.user.dto.LoginRequestDTO;
import com.todolist_java.domain.user.dto.LoginResponseDTO;
import com.todolist_java.domain.user.dto.SignUpRequestDTO;
import com.todolist_java.domain.user.dto.UserResponseDTO;
import com.todolist_java.domain.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO, HttpServletResponse response){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.login(requestDTO, response));
    }

    @GetMapping("/getuser")
    public ResponseEntity<UserResponseDTO> getUser(@RequestParam String username){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUser(username));
    }

}
