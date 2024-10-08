package com.todolist_java.domain.comment.model;

import com.todolist_java.domain.todo.model.Todo;
import com.todolist_java.domain.user.model.User;
import com.todolist_java.infra.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "comment")
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="content")
    private String content;

    @Column(name="writer")
    private String writer;
    // 인증인가 구현되면 유저아이디 넣기

//    @ManyToOne
//    @JoinColumn(name = "user")
//    private User user;

    @ManyToOne
    @JoinColumn(name = "todo")
    private Todo todo;

    public Comment(String content, String writer,Todo todo){
        this.content = content;
        this.writer = writer;
        this.todo = todo;
    }

    public void updateComment(String content){
        this.content = content;
    }

}
