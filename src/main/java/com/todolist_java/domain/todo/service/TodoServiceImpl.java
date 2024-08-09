package com.todolist_java.domain.todo.service;

import com.todolist_java.domain.todo.dto.TodoRequestDTO;
import com.todolist_java.domain.todo.dto.TodoResponseDTO;
import com.todolist_java.domain.todo.model.Todo;
import com.todolist_java.domain.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

//싱글톤 단 하나의 객체만 생성해서 스프링이 관리한다
// 그걸 빈이라고 부른다
// 스프링부트 -> 객체지향 싱글톤 mvc 다 적용된거 근데 이해를 안하고 갖다 박으니까 어려움
//
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    @Transactional
    public TodoResponseDTO createTodo(TodoRequestDTO todoRequestDTO) {

//        Todo todo = new Todo(todoRequestDTO);

        //        Todo todo = todoRequestDTO.toTodo();
//        Todo todo = todoRequestDTO.toEntity();


        Todo todo = todoRequestDTO.toTodo();
        //생성책임이 dto에 있다
        //책임차이
        //정답은 없다 이유만 있으면 된다

//        Todo todo2 = new Todo(
//                todoRequestDTO.getTitle(),
//                todoRequestDTO.getContent(),
//                todoRequestDTO.getWriter(),
//                todoRequestDTO.getPassword()
//        );
        //생성 책임이 서비스에 있다




        todoRepository.save(todo);
        return TodoResponseDTO.fromTodo(todo);
    }

    //옵셔널

    @Override
    @Transactional
    public TodoResponseDTO updateTodo(Long todoId,TodoRequestDTO todoRequestDTO) {
        Todo todo = todoRepository
                .findByIdAndPassword(todoId,todoRequestDTO.getPassword())
                .orElseThrow(()->new IllegalArgumentException("니꺼아님"));

        todo.update(todoRequestDTO.getTitle(),todoRequestDTO.getContent(),todoRequestDTO.getWriter());
        todoRepository.save(todo);
        return TodoResponseDTO.fromTodo(todoRepository.save(todo));
        }


    @Override
    public void deleteTodo(Long todoId, String password) {
        Todo todo = todoRepository
                .findByIdAndPassword(todoId,password)
                .orElseThrow(()->new IllegalArgumentException("아이디랑 패스워드 확인"));
        todoRepository.delete(todo);
    }

    @Override
    public TodoResponseDTO getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(()-> new IllegalArgumentException("작성자 없다잉"));
        return TodoResponseDTO.fromTodo(todo);
    }

    @Override
    public List<TodoResponseDTO> getAllTodos() {
        List<Todo> todoList = todoRepository.findAll();
        todoList.sort(Comparator.comparing(Todo::getCreatedAt).reversed());
        return todoList.stream().map(TodoResponseDTO::fromTodo).toList();
    }
    }


