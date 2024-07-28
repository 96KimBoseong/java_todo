package com.todolist_java.domain.todo.dto;

import com.todolist_java.domain.todo.model.Todo;
import lombok.*;

@Getter//Jackson 을 써서 직렬화 / 역직렬화를 하는데 이때 필요하단다
//@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class TodoRequestDTO {

    private String title;
    private String content;
    private String writer;
    private String password;

    public Todo toTodo() {
        return new Todo(
                this.title,
                this.content,
                this.writer,
                this.password
        );
    }

    //dto가 엔티티를 알게되는건 상관이 없나?
    // dto가 엔티티를 알아도된다 근데 반대는 알면 꼬라박기행위가 실행된다
    // dto가 엔티티를 의존하는 형태이고 알아도 무방하다
    // 컨트롤러는 db를 알아도 되나 반대는 안된다
    // 내부는 변화가 자주 일어나지 않는다 데이터베이스의 변화를 안전하게 의존성의 방향
    // 컨트롤러가 바뀔때마다 데이터베이스가 자주 바뀌는건 문제가 있다\
    //비즈니스로직이 가장 중요하다

//    public Todo toEntity(){
//        return Todo.builder()
//                .title(title)
//                .content(content)
//                .writer(writer)
//                .password(password)
//                .build();
//    }
    //확실하게 명시해주려고 빌더패턴을 사용한다
    //정답은 아니다 상황에 따라 다름

    }



//빌더 써?
// 계층간 침범을 다시 생각해보아라.. 그걸 코드로 바꾸는게 어렵다잉
