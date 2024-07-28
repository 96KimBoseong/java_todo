package com.todolist_java.domain.todo.dto;

import com.todolist_java.domain.comment.dto.CommentResponseDTO;
import com.todolist_java.domain.comment.model.Comment;
import com.todolist_java.domain.todo.model.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private List<CommentResponseDTO> commentList;


    public static TodoResponseDTO fromTodo(Todo todo) {

        List<CommentResponseDTO> comments = todo.getComments().stream().map(CommentResponseDTO::fromComment).toList();
        // 엔티티 리스트 덩어리 dto 덩어리로 변환
        return new TodoResponseDTO(
                todo.getId(),
                todo.getTitle(),
                todo.getContent(),
                todo.getWriter(),
                todo.getCreatedAt(),
                comments
        );
    }

//    public static TodoResponseDTO fromTodo(Todo todo) {
//        return TodoResponseDTO.builder()
//                .id(todo.getId())
//                .title(todo.getTitle())
//                .content(todo.getContent())
//                .writer(todo.getWriter())
//                .createdAt(todo.getCreatedAt())
//                .commentList(todo.getComments())
//                .build();
//
//    }
//    public static TodoResponseDTO from(Todo todo) {
//        return TodoResponseDTO(
//                this.title =todo.getTitle()
//
//        )
//    }
}
