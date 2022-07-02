package com.nychat.reactiverest.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

import java.util.Random;

@Configuration
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class SampleDataInitializer {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {

        userRepository.deleteAll()
                .subscribe();


        Flux.just( "user 012", "user 013", "user 014", "user 015")
                .map(name -> Member.builder()
                        .id(String.valueOf(new Random().nextInt(100, 500)))
                        .name(name)
                        .access(new Random().nextBoolean())
                        .build())
                .flatMap(userRepository::save)
                .subscribe();
        Flux.just( "mod 012", "mod 013", "mod 014", "mod 015")
                .map(name -> Moderator.builder()
                        .id(String.valueOf(new Random().nextInt(100, 500)))
                        .name(name)
                        .access(new Random().nextBoolean())
                        .build())
                .flatMap(userRepository::save)
                .subscribe();
        Flux.just( "adm 052", "adm 053", "adm 054", "adm 055")
                .map(name -> Admin.builder()
                        .id(String.valueOf(new Random().nextInt(100, 500)))
                        .name(name)
                        .access(new Random().nextBoolean())
                        .build())
                .flatMap(userRepository::save)
                .subscribe();

        return args -> {
        };
    }

}
