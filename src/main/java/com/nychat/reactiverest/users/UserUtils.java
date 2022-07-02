package com.nychat.reactiverest.users;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class UserUtils {

    private final ModelMapper modelMapper;

//    public User convertToEntity(UserPayload payload) {
//        return modelMapper.map(payload, User.class);
//    }

    public UserPayload convertToDTO(User entity) {
        return modelMapper.map(entity, UserPayload.UserPayloadBuilder.class)
                .build();
    }


}
