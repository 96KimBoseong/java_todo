package com.todolist_java.domain.todo.dto;

import com.todolist_java.domain.todo.model.Todo;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class TodoResponseDTO {
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;



    public static TodoResponseDTO fromTodo(Todo todo) {
        return TodoResponseDTO.builder()
                .title(todo.getTitle())
                .content(todo.getContent())
                .writer(todo.getWriter())
                .createdAt(todo.getCreatedAt())
                .build();

    }
//    public static TodoResponseDTO from(Todo todo) {
//        return TodoResponseDTO(
//                this.title =todo.getTitle()
//
//        )
//    }
}
