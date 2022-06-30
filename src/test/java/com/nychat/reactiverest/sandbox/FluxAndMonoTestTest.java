package com.nychat.reactiverest.sandbox;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoTestTest {


    @Test
    void fluxTest() {
        Flux<String> stringFlux = Flux.just("Java", "Spring", "Maven", "Gradle")
//                .concatWith(Flux.error(new RuntimeException("Error!")))
                .concatWith(Flux.just("new Start"))
                .log();

        stringFlux
                .subscribe(s -> System.out.println("- " + s),
                        throwable -> System.out.println("#" + throwable),
                        () -> System.out.println("DONE!"));

    }

    @Test
    void fluxElementsTest_WithoutError() {
        Flux<String> stringFlux = Flux.just("Java", "Spring", "Gradle")
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("Java")
                .expectNext("Spring")
                .expectNext("Gradle")
                .verifyComplete();



    }

    @Test
    void fluxElementsTest_WithError() {
        Flux<String> stringFlux = Flux.just("Java", "Spring", "Gradle")
                .concatWith(Flux.error(new RuntimeException("Error!")))
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("Java", "Spring", "Gradle")
//                .expectError(RuntimeException.class)
                .expectErrorMessage("Error!")
                .verify();



    }

    @Test
    void fluxElementsCountTest_WithError() {
        Flux<String> stringFlux = Flux.just("Java", "Spring", "Gradle")
                .concatWith(Flux.error(new RuntimeException("Error!")))
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(3)
//                .expectError(RuntimeException.class)
                .expectErrorMessage("Error!")
                .verify();

    }

    @Test
    void monoTest() {

        Mono<String> spring = Mono.just("Spring").log();

        StepVerifier.create(spring)
                .expectNext("Spring")
                .verifyComplete()
        ;

    }

    @Test
    void monoTest_WithError() {

        StepVerifier.create(Mono.error(new RuntimeException("Error!")).log())
                .expectError(RuntimeException.class)
                .verify();


    }
}