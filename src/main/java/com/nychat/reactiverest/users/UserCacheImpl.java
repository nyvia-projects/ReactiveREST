package com.nychat.reactiverest.users;

import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Random;

@Repository
@RequiredArgsConstructor
public class UserCacheImpl implements UserCache {

    private final ReactiveRedisConnectionFactory factory;
    private final ReactiveRedisOperations<String, User> operations;


    @PostConstruct
    public void loadData() {
        factory.getReactiveConnection()
                .serverCommands()
                .flushAll()
                .thenMany(
                        Flux.just("U$ER 01", "u$eR 02", "us3r o3")
                                .map(name -> Member.builder()
                                        .id(String.valueOf(new Random().nextInt(0, 10)))
                                        .name(name)
                                        .access(new Random().nextBoolean())
                                        .build())
                                .flatMap(user -> operations.opsForValue()
                                        .set(user.getId(), user)))
                .subscribe();


    }

    @Override
    public <S extends User> Mono<S> save(S entity) {
        return null;
    }

    @Override
    public <S extends User> Flux<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends User> Flux<S> saveAll(Publisher<S> entityStream) {
        return null;
    }

    @Override
    public Mono<User> findById(String s) {
        return null;
    }

    @Override
    public Mono<User> findById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(String s) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<String> id) {
        return null;
    }

    @Override
    public Flux<User> findAll() {
        return null;
    }

    @Override
    public Flux<User> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public Flux<User> findAllById(Publisher<String> idStream) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String s) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Void> delete(User entity) {
        return null;
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<? extends String> strings) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends User> entities) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends User> entityStream) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
