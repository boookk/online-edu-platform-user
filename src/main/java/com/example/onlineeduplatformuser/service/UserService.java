package com.example.onlineeduplatformuser.service;

import com.example.onlineeduplatformuser.dto.UserRegistrationResponse;
import com.example.onlineeduplatformuser.model.User;
import com.example.onlineeduplatformuser.model.UserType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface UserService {

    // 학생 등록
    Mono<User> registrationStudent(User user);

//    Mono<User> registrationStudent(ServerRequest request);


//    UserRegistrationResponse registrationTeacher(ServerRequest serverRequest);
//
//    UserRegistrationResponse registrationStudent(ServerRequest serverRequest);
//
//    UserLoginResponse loginService(ServerRequest serverRequest);

}
