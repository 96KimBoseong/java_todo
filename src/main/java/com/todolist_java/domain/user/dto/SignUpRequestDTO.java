package com.todolist_java.domain.user.dto;

import com.todolist_java.domain.user.model.User;
import com.todolist_java.domain.user.model.UserRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequestDTO {

    private String nickname;
    private String username;
    private String password;
    private UserRole role;

    public User toUser(){
       return new User(
               this.nickname ,
               this.username,
               this.password,
               this.role
       );
    }
}
