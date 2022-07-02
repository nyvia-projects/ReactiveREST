package com.nychat.reactiverest.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }

    public Mono<User> getUserById(String id) {
        return userRepository.findById(id);
    }

}
