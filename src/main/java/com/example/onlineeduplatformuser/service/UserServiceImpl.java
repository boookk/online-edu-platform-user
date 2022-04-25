package com.example.onlineeduplatformuser.service;

import com.example.onlineeduplatformuser.dto.UserRegistrationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public UserRegistrationResponse registrationTeacher(ServerRequest serverRequest) {
        return null;
    }

    @Override
    public UserRegistrationResponse registrationStudent(ServerRequest serverRequest) {
        return null;
    }

    @Override
    public UserRegistrationResponse loginService(ServerRequest serverRequest) {
        return null;
    }
}
