package com.todolist_java.domain.todo.service;

import com.todolist_java.domain.todo.dto.TodoRequestDTO;
import com.todolist_java.domain.todo.dto.TodoResponseDTO;
import com.todolist_java.domain.todo.model.Todo;
import com.todolist_java.domain.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;


@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    @Transactional
    public TodoResponseDTO createTodo(TodoRequestDTO todoRequestDTO) {

        String title = todoRequestDTO.getTitle();
        String content = todoRequestDTO.getContent();
        String writer = todoRequestDTO.getWriter();
        String password = todoRequestDTO.getPassword();


        if (title.isEmpty() || content.isEmpty() || writer.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("모든 항목을 채워주세요");
        }

        //유효성검증 여기서 하지마라 ~!


        Todo todo = todoRequestDTO.toEntity();
        todoRepository.save(todo);
        return TodoResponseDTO.fromTodo(todo);
    }

    //옵셔널

    @Override
    @Transactional
    public TodoResponseDTO updateTodo(TodoRequestDTO todoRequestDTO) {
        Todo todo = todoRepository
                .findByWriterAndPassword(todoRequestDTO.getWriter(),todoRequestDTO.getPassword())
                .orElseThrow(()->new IllegalArgumentException("니꺼아님"));

        todo.update(todoRequestDTO.getTitle(),todoRequestDTO.getContent());
        todoRepository.save(todo);
        return TodoResponseDTO.fromTodo(todoRepository.save(todo));
        }


    @Override
    public void deleteTodo(String writer, String password) {
        Todo todo = todoRepository
                .findByWriterAndPassword(writer,password)
                .orElseThrow(()->new IllegalArgumentException("아이디랑 패스워드 확인"));
        todoRepository.delete(todo);
    }

    @Override
    public TodoResponseDTO getTodo(String writer) {
        Todo todo = todoRepository.findByWriter(writer)
                .orElseThrow(()-> new IllegalArgumentException("작성자 없다잉"));
        return TodoResponseDTO.fromTodo(todo);
    }

    @Override
    public List<TodoResponseDTO> getAllTodos() {
        List<Todo> todoList = todoRepository.findAll();
        todoList.sort(Comparator.comparing(Todo::getCreatedAt).reversed());
        return todoList.stream().map(TodoResponseDTO::fromTodo).toList();
    }
    //이거 손봐야댐 하나만 나옴
    }


