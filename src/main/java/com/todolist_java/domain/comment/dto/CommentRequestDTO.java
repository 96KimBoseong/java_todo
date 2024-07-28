package com.todolist_java.domain.comment.dto;

import com.todolist_java.domain.comment.model.Comment;
import com.todolist_java.domain.todo.model.Todo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentRequestDTO {
    private String content;

    public Comment toComment(Todo todo){
        return new Comment(
                this.content,
                todo
        );
    }// 이래도 만들어지나?

}
