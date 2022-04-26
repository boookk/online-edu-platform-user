package com.example.onlineeduplatformuser.repository;

import com.example.onlineeduplatformuser.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends ReactiveCrudRepository<User, Long> {


    @Query("SELECT MAX(userId) FROM user")
    Integer findByLastId();
}
