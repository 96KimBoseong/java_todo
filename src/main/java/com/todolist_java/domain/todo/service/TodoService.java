package com.todolist_java.domain.todo.service;

import com.todolist_java.domain.todo.dto.TodoRequestDTO;
import com.todolist_java.domain.todo.dto.TodoResponseDTO;

import java.util.List;


public interface TodoService {
    TodoResponseDTO createTodo(TodoRequestDTO todoRequestDTO);

    TodoResponseDTO updateTodo(TodoRequestDTO todoRequestDTO);

    void deleteTodo(String writer, String password);

    TodoResponseDTO getTodo(String writer);

    List<TodoResponseDTO> getAllTodos();
}
