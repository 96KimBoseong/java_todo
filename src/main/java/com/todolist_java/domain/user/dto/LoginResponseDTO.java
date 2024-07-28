package com.todolist_java.domain.user.dto;

import com.todolist_java.domain.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String nickname;
    private String username;
    private String token;


    public static LoginResponseDTO formUserWithToken(Long id, String nickname, String username, String token) {
        return new LoginResponseDTO(id, nickname, username,token);
    }
}
