package com.todolist_java.domain.comment.repository;

import com.todolist_java.domain.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
