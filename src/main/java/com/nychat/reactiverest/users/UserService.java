package com.nychat.reactiverest.users;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

   private final UserRepository userRepository;

    public Mono<User> saveUser(User user) {
       return userRepository.save(user);
    }

    public Mono<User> getUserById(String id) {
        return userRepository.findById(id);
    }

}
