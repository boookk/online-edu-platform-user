package com.example.onlineeduplatformuser.handler;

import com.example.onlineeduplatformuser.dto.UserRegistrationResponse;
import com.example.onlineeduplatformuser.model.User;
import com.example.onlineeduplatformuser.repository.UserRepository;
import com.example.onlineeduplatformuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
@Component
public class UserHandler {


    private UserService userService;
    private UserRepository userRepository;

    public Mono<ServerResponse> register(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("Test");
    }

    public Mono<ServerResponse> join(ServerRequest request) {
//        Mono<User> response = userService.registrationStudent(request).subscribeOn(Schedulers.boundedElastic());

        // 학생 등록
        Mono<User> response = request.bodyToMono(User.class)
                .flatMap(user -> userService.registrationStudent(user))
                .log();

//        Mono<User> response = request.bodyToMono(Map.class)
//                .flatMap(user -> userService.registrationStudent(user))
//                .log();

        userRepository.findAll().doOnNext(user -> {
            log.info(user.toString());
        }).blockLast(Duration.ofSeconds(10));

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response, UserRegistrationResponse.class);
    }

//    Mono<ServerResponse> login(ServerRequest serverRequest);
}
