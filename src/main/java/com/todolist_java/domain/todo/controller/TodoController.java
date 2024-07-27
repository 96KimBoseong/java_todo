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
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

//    public TodoController(TodoService todoService) {
//        this.todoService = todoService;
//    }

    @PostMapping("/create")
    public ResponseEntity<TodoResponseDTO> createTodo(@RequestBody TodoRequestDTO todoRequestDTO){
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(todoService.createTodo(todoRequestDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<TodoResponseDTO> updateTodo(@RequestBody TodoRequestDTO todoRequestDTO){
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(todoService.updateTodo(todoRequestDTO));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteTodo(@RequestParam String writer, @RequestParam String password){
        todoService.deleteTodo(writer,password);
        return ResponseEntity.
                status(HttpStatus.NO_CONTENT)
                .build();
    }
    @GetMapping("/get")
    public ResponseEntity<TodoResponseDTO> getTodo(@RequestParam String writer){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.getTodo(writer));
    }

    @GetMapping("/getList")
    public ResponseEntity<List<TodoResponseDTO>> getTodoList(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.getAllTodos());
    }

}
