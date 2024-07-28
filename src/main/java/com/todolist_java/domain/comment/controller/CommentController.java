package com.todolist_java.domain.comment.controller;

import com.todolist_java.domain.comment.dto.CommentRequestDTO;
import com.todolist_java.domain.comment.dto.CommentResponseDTO;
import com.todolist_java.domain.comment.dto.CommentUpdateDTO;
import com.todolist_java.domain.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/creat/{todoId}")
    public ResponseEntity<CommentResponseDTO> createComment(@RequestBody CommentRequestDTO requestDTO, @PathVariable Long todoId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(commentService.createComment(requestDTO, todoId));
    }

    @PatchMapping("/update/{todoId}/{commentId}")
    public ResponseEntity<CommentResponseDTO> updateComment(@RequestBody CommentUpdateDTO requestDTO, @PathVariable Long todoId, @PathVariable Long commentId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.updateComment(requestDTO,todoId,commentId));
    }
    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/{commentId}")
//    public ResponseEntity<CommentResponseDTO> getComment(@PathVariable Long commentId) {
//        return null;
//    }
//    @GetMapping("/{todoId}")
//    public ResponseEntity<List<CommentResponseDTO>> getComments(@PathVariable Long todoId) {
//        return null;
//    }
}
