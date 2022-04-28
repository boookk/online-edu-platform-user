package com.example.onlineeduplatformuser.service;

import com.example.onlineeduplatformuser.dto.UserDto;
import com.example.onlineeduplatformuser.dto.UserLoginResponse;
import com.example.onlineeduplatformuser.model.User;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface UserService {
    // UserRegistrationResponse registrationTeacher(ServerRequest serverRequest);
    //
//     Mono<User> registrationStudent(UserDto userDto);

    Mono<UserLoginResponse> loginService(Map<String, Object> param);

}
