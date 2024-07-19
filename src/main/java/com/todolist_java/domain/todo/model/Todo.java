package com.todolist_java.domain.todo.model;

import com.todolist_java.infra.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo")
public class Todo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name= "content")
    private String content;

    @Column(name= "writer")
    private String writer;

    @Column(name= "password")
    private String password;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}

