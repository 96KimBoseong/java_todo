package com.todolist_java.domain.todo.repository;

import com.todolist_java.domain.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findByIdAndPassword (Long todoId, String password);
}
