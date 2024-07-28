package com.todolist_java.domain.comment.service;

import com.todolist_java.domain.comment.dto.CommentRequestDTO;
import com.todolist_java.domain.comment.dto.CommentResponseDTO;
import com.todolist_java.domain.comment.dto.CommentUpdateDTO;
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
    public CommentResponseDTO updateComment(CommentUpdateDTO commentUpdateDTO, Long todoId, Long commentId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new IllegalArgumentException("todo not found"));
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new IllegalArgumentException("comment not found"));

        //todo 와 comment에 fk가 같지 않으면 바꾸면 안되겠죠잉
        if (todo== comment.getTodo()) {
            comment.updateComment(commentUpdateDTO.getContent());
            commentRepository.save(comment);
        }else{
            throw new IllegalStateException("todo does not belong to this comment");
        }
        return CommentResponseDTO.fromComment(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new IllegalArgumentException("comment not found"));
        commentRepository.delete(comment);

    }
}
