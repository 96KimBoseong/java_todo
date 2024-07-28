package com.todolist_java.domain.todo.service;

import com.todolist_java.domain.todo.dto.TodoRequestDTO;
import com.todolist_java.domain.todo.dto.TodoResponseDTO;

import java.util.List;


public interface TodoService {
    TodoResponseDTO createTodo(TodoRequestDTO todoRequestDTO);

    TodoResponseDTO updateTodo(Long todoId,TodoRequestDTO todoRequestDTO);

    void deleteTodo(Long todoId, String password);

    TodoResponseDTO getTodo(Long todoId);

    List<TodoResponseDTO> getAllTodos();
}
