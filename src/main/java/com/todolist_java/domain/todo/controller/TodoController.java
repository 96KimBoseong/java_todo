package com.todolist_java.domain.todo.controller;

import com.todolist_java.domain.todo.dto.TodoRequestDTO;
import com.todolist_java.domain.todo.dto.TodoResponseDTO;
import com.todolist_java.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public ResponseEntity<TodoResponseDTO> createTodo(@RequestBody TodoRequestDTO todoRequestDTO){
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(todoService.createTodo(todoRequestDTO));
    }

    @PutMapping("/update/{todoId}")
    public ResponseEntity<TodoResponseDTO> updateTodo(@RequestBody TodoRequestDTO todoRequestDTO, @PathVariable Long todoId){
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(todoService.updateTodo(todoId,todoRequestDTO));
    }
    @DeleteMapping("/delete/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId, @RequestParam String password){
        todoService.deleteTodo(todoId,password);
        return ResponseEntity.
                status(HttpStatus.NO_CONTENT)
                .build();
    }
    @GetMapping("/get/{todoId}")
    public ResponseEntity<TodoResponseDTO> getTodo( @PathVariable Long todoId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.getTodo(todoId));
    }

    @GetMapping("/getList")
    public ResponseEntity<List<TodoResponseDTO>> getTodoList(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.getAllTodos());
    }

}
