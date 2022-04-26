package com.example.onlineeduplatformuser.service;

import com.example.onlineeduplatformuser.model.User;
import com.example.onlineeduplatformuser.model.UserType;
import com.example.onlineeduplatformuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    // 학생 등록
    @Override
    public Mono<User> registrationStudent(User user) {
        int userId = userRepository.findByLastId() + 1;
        user.setUserId(userId);
        user.setUserType(UserType.STUDENT.getValue());

        log.info(String.valueOf(userId));

        return userRepository.save(user);
    }
}
