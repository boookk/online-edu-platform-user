package com.example.onlineeduplatformuser.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public interface UserHandler {

    Mono<ServerResponse> register(ServerRequest serverRequest);

    Mono<ServerResponse> join(ServerRequest serverRequest);

    Mono<ServerResponse> login(ServerRequest serverRequest);
}
