package com.todolist_java.domain.comment.service;

import com.todolist_java.domain.comment.dto.CommentRequestDTO;
import com.todolist_java.domain.comment.dto.CommentResponseDTO;
import com.todolist_java.domain.comment.dto.CommentUpdateDTO;

public interface CommentService {
     CommentResponseDTO createComment(CommentRequestDTO commentRequestDTO, Long todoId);
     CommentResponseDTO updateComment(CommentUpdateDTO commentUpdateDTO, Long todoId, Long commentId);
     void deleteComment(Long commentId);
}
