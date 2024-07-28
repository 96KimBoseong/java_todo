package com.todolist_java.domain.comment.service;

import com.todolist_java.domain.comment.dto.CommentRequestDTO;
import com.todolist_java.domain.comment.dto.CommentResponseDTO;

public interface CommentService {
    public CommentResponseDTO createComment(CommentRequestDTO commentRequestDTO, Long todoId);
    public CommentResponseDTO updateComment(CommentRequestDTO commentRequestDTO, Long todoId);
    public CommentResponseDTO deleteComment(Long commentId);
}
