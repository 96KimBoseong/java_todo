package com.todolist_java.domain.user.dto;

import com.todolist_java.domain.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String nickname;
    private String username;


    public static UserResponseDTO forUser(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getNickname(),
                user.getUsername()
        );
    }
}
