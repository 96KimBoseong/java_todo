package com.todolist_java.domain.comment.dto;

import com.todolist_java.domain.comment.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDTO {
    private String content;
    private Long todoId;
    private LocalDateTime createdAt;


    public static CommentResponseDTO fromComment(Comment comment) {
        return new CommentResponseDTO(
                comment.getContent(),
                comment.getTodo().getId(),
                comment.getCreatedAt()

        );
    }

}




