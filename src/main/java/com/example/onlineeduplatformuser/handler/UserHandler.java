package com.example.onlineeduplatformuser.handler;

import com.example.onlineeduplatformuser.dto.UserRegistrationResponse;
import com.example.onlineeduplatformuser.model.User;
import com.example.onlineeduplatformuser.model.UserType;
import com.example.onlineeduplatformuser.repository.UserRepository;
import com.example.onlineeduplatformuser.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserHandler {

    private final Validator validator;
    private UserService userService;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public Mono<ServerResponse> register(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("Test");
    }

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ok().body(userRepository.findAll(), UserRegistrationResponse.class).log();
    }

    public Mono<ServerResponse> join(ServerRequest request) {
        Mono<User> response = request.bodyToMono(User.class).doOnNext(this::validate);
        return response
                .flatMap(user -> {
                    user.setUserType(UserType.STUDENT.getValue());
                    user.setUserId(userRepository.findByLastId());
                    return ok().body(userRepository.save(objectMapper.convertValue(user, User.class)), UserRegistrationResponse.class);
                })
                .log();
    }

    private void validate(Object object) {
        Errors errors = new BeanPropertyBindingResult(object, object.getClass().getName());
        validator.validate(object, errors);
        if (errors.hasErrors()) {
            throw new ServerWebInputException(errors.toString());
        }
    }

//    Mono<ServerResponse> login(ServerRequest serverRequest);
}
