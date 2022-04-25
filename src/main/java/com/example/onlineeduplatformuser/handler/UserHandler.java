package com.example.onlineeduplatformuser.handler;

import com.example.onlineeduplatformuser.dto.UserLoginResponse;
import com.example.onlineeduplatformuser.dto.UserRegistrationResponse;
import com.example.onlineeduplatformuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {

    private final UserService userService;

    public Mono<ServerResponse> register(ServerRequest serverRequest) {
        return ServerResponse.ok().body(userService.registrationTeacher(serverRequest),
                UserRegistrationResponse.class);
    }

    public Mono<ServerResponse> join(ServerRequest serverRequest) {
        return ServerResponse.ok().body(userService.registrationStudent(serverRequest),
                UserRegistrationResponse.class);
    }

    public Mono<ServerResponse> login(ServerRequest serverRequest) {
        return ServerResponse.ok().body(userService.loginService(serverRequest),
                UserLoginResponse.class);
    }
}
