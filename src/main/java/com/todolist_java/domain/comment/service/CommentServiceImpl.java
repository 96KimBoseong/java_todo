package com.todolist_java.domain.comment.service;

import com.todolist_java.domain.comment.dto.CommentRequestDTO;
import com.todolist_java.domain.comment.dto.CommentResponseDTO;
import com.todolist_java.domain.comment.model.Comment;
import com.todolist_java.domain.comment.repository.CommentRepository;
import com.todolist_java.domain.todo.model.Todo;
import com.todolist_java.domain.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;
    public CommentServiceImpl(CommentRepository commentRepository,TodoRepository todoRepository) {
        this.commentRepository = commentRepository;
        this.todoRepository =todoRepository;
    }

    @Override
    public CommentResponseDTO createComment(CommentRequestDTO commentRequestDTO, Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new IllegalArgumentException("todo not found"));
        Comment comment = commentRequestDTO.toComment(todo);
//        todo.addComment(comment);
        //연관관계 있어서 굳이 안바까줘도 괜찮음
        commentRepository.save(comment);
        return CommentResponseDTO.fromComment(comment);
    }

    @Override
    public CommentResponseDTO updateComment(CommentRequestDTO commentRequestDTO, Long todoId) {
        return null;
    }

    @Override
    public CommentResponseDTO deleteComment(Long commentId) {
        return null;
    }
}
