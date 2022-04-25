package com.example.onlineeduplatformuser.service;

import com.example.onlineeduplatformuser.dto.UserRegistrationResponse;
import org.springframework.web.reactive.function.server.ServerRequest;

public interface UserService {

    UserRegistrationResponse registrationTeacher(ServerRequest serverRequest);

    UserRegistrationResponse registrationStudent(ServerRequest serverRequest);

    UserRegistrationResponse loginService(ServerRequest serverRequest);

}
