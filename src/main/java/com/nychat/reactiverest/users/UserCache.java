package com.nychat.reactiverest.users;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserCache extends ReactiveCrudRepository<User, String> {
}
