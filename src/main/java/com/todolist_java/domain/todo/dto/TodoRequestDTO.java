package com.todolist_java.domain.todo.dto;

import com.todolist_java.domain.todo.model.Todo;
import lombok.*;

@Getter//Jackson 을 써서 직렬화 / 역직렬화를 하는데 이때 필요하단다
@Builder
public class TodoRequestDTO {

    private String title;
    private String content;
    private String writer;
    private String password;


    public Todo toEntity(){
        return Todo.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .password(password)
                .build();
    }

}



//빌더 써?
// 계층간 침범을 다시 생각해보아라.. 그걸 코드로 바꾸는게 어렵다잉
