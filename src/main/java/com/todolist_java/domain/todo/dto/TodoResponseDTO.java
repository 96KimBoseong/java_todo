package com.todolist_java.domain.todo.dto;

import com.todolist_java.domain.comment.model.Comment;
import com.todolist_java.domain.todo.model.Todo;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class TodoResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private List<Comment> commentList;



    public static TodoResponseDTO fromTodo(Todo todo) {
        return TodoResponseDTO.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .content(todo.getContent())
                .writer(todo.getWriter())
                .createdAt(todo.getCreatedAt())
                .commentList(todo.getComments())
                .build();

    }
//    public static TodoResponseDTO from(Todo todo) {
//        return TodoResponseDTO(
//                this.title =todo.getTitle()
//
//        )
//    }
}
