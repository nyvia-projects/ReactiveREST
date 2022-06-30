package com.nychat.reactiverest.config;

import com.nychat.reactiverest.users.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.*;

@Configuration
//@EnableRedisRepositories
public class RedisConfiguration {


//    @Value("${spring.redis.port}") int redisPort;
//    @Value("${spring.redis.host}") String redisHost;


    @Bean
    public ReactiveRedisOperations<String, User> redisOperations(ReactiveRedisConnectionFactory factory) {
//        RedisStandaloneConfiguration redisStandaloneConfig = new RedisStandaloneConfiguration(redisHost, redisPort);
////        redisStandaloneConfig.setPassword();
//
//        ReactiveRedisConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfig);


        Jackson2JsonRedisSerializer<User> serializer  = new Jackson2JsonRedisSerializer<>(User.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, User> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, User> context = builder.value(serializer)
                .build();

        return new ReactiveRedisTemplate<>(factory, context);
    }


}
