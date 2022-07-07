package com.nychat.reactiverest.users;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class UserHttpRouter {

    private final UserService userService;
    private final UserUtils utils;


    @Bean
    public RouterFunction<ServerResponse> getStudentsRoute() {
        return route(GET("/users"),
                request ->
                        ok().body(userService.getAll()
                                .map(utils::convertToDTO), UserPayload.class));
    }



}