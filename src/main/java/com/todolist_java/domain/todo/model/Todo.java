package com.todolist_java.domain.todo.model;

import com.todolist_java.infra.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "todo")
public class Todo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name= "content")
    private String content;

    @Column(name= "writer")
    private String writer;

    @Column(name= "password")
    private String password;

//    public Todo(TodoRequestDTO todoRequestDTO) {
//        this.title = todoRequestDTO.getTitle();
//        this.content = todoRequestDTO.getContent();
//        this.writer = todoRequestDTO.getWriter();
//        this.password = todoRequestDTO.getPassword();
//    }
    // dto를 매개변수로 받아버리면 데이터베이스가 컨트롤러를 알게 되버려서 독립적으로 있을수가 없음
    // 유저가 보내준값을 그대로 데이터베이스 꼬라박는 행위는 문제가있다

    public Todo(String title, String content, String writer, String password) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
    }
    //개꿀 분해해서 받아서 get 으로



    //얘는 업뎃용 무시
    public void update(String title, String content,String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    //취향인데 엔티티 안에 비즈니스로직이 들어가는게
    // 엔티티와 비즈니스 로직을 순수하게 분리하는게 아니라면 걍 써도됨
    // 파라미터/ 필더가 많아지면 필드를 공통적으로 묶을 수 있게 vo를 던지고 받으면서? vo?

    // 엔티티는 데이터베이스 테이블을 가르키는 객체고 대응되는  todo라는 순수한 객체를 만든다?
    // db 테이블를 바라보는 객체가 아니라 그냥 백엔드에서 사용하는 도메인객체 db랑 관련은 없다?
    // 도메인 객체없이 엔티팉를 도메인객체처럼 쓰고있기 때문에 도메인 로직을 엔티티에 넣어도 괜찮다?
    // 명시적 save를써도 쓰기지연에 있는게 나가는거라 상관 x다

    // 트랜잭션이 꼭 필요한 경우에만 쓴다?
    // 데이터 변경이 필요하다 ?
    // 포조 객체 클래스

    // 엔티티가 db랑 1:1 대응되고있는 상황
    // 도메인객체랑 db테이블은 분리가 되는게 맞는데
    // jpa를 쓰면 두가지를 섞은거다
    // 클린코드 클린아키텍쳐

    // 레포지토리는 포조다 서비스에서 필요로 하는 외부에서 처리해줘야 할 것들을 정의한다

    // 트랜잭션이 db작업을 여러번 하면 중간에 하나가 실패했을때 그 앞에서 진행했던 모든 작업을 한번에 롤백 시켜줘야하는데 그 작업단위가 트랜잭션
    // 근데 생성을 하나 할때 ?
    // 더티체킹은 트랜잭션이 있어야만 돌아간다
    //




}

