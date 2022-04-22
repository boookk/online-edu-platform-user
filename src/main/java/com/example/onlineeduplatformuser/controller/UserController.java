package com.example.onlineeduplatformuser.controller;

import com.example.onlineeduplatformuser.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class UserController {

    @Bean
    public RouterFunction<ServerResponse> UserRouter(UserHandler userHandler) {
        return RouterFunctions.route()
                .POST("/user", userHandler::createTeacher)
                .POST("/user/join", userHandler::join)
                .POST("/user/login", userHandler::login)
                .build();
    }
}
