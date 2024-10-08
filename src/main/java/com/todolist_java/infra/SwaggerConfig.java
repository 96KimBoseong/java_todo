package com.todolist_java.infra;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class SwaggerConfig {

        @Bean
        public OpenAPI openAPI() {
            return new OpenAPI()
                    .info(
                            new Info()
                                    .title("todoList API")
                                    .description("CatTower API schema")
                                    .version("1.0.0")
                    );
        }
    }
