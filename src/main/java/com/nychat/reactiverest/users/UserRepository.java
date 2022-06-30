package com.nychat.reactiverest.users;

import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {


    Mono<User> findByName(String name);

    Mono<User> findByAccess(boolean access);

    Mono<Boolean> hasAccessById(String id);

    Mono<Boolean> hasAccessByName(String name);
}
