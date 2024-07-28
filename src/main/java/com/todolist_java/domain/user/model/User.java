package com.todolist_java.domain.user.model;

import com.todolist_java.infra.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "user")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nick_name")
    private String nickname;

    @Column(name = "user_name")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "role")
    private UserRole role;

    public User(String nickname, String username, String password, UserRole role) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
