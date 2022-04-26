package com.example.onlineeduplatformuser.handler;

import com.example.onlineeduplatformuser.dto.UserDto;
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

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserHandler {

    private final Validator validator;
    private UserService userService;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;


    // 강사 등록
   public Mono<ServerResponse> register(ServerRequest request) {
        Mono<UserDto> userDto = request.bodyToMono(UserDto.class).doOnNext(this::validate);
        return userDto
                .flatMap(user -> {
                    user.setUserType(UserType.TEACHER.getValue());
                    return ok().body(userRepository.save(objectMapper.convertValue(user, User.class)), UserRegistrationResponse.class);
                })
                .log();
    }
    

    // 학생 등록
    public Mono<ServerResponse> join(ServerRequest request) {
        Mono<UserDto> userDto = request.bodyToMono(UserDto.class).doOnNext(this::validate);
        return userDto
                .flatMap(user -> {
                    user.setUserType(UserType.STUDENT.getValue());
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
