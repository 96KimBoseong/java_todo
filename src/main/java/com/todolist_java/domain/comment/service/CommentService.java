package com.todolist_java.domain.comment.service;

import com.todolist_java.domain.comment.dto.CommentRequestDTO;
import com.todolist_java.domain.comment.dto.CommentResponseDTO;
import com.todolist_java.domain.comment.dto.CommentUpdateDTO;

public interface CommentService {
    public CommentResponseDTO createComment(CommentRequestDTO commentRequestDTO, Long todoId);
    public CommentResponseDTO updateComment(CommentUpdateDTO commentUpdateDTO, Long todoId, Long commentId);
    public CommentResponseDTO deleteComment(Long commentId);
}
