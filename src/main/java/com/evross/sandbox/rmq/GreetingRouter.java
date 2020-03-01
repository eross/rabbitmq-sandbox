package com.evross.sandbox.rmq;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions.route()
        .GET("/hello", accept(MediaType.TEXT_PLAIN), greetingHandler::hello)
        .GET("/hello/{msg}", accept(MediaType.TEXT_PLAIN), greetingHandler::hello)
        .build();
    }
}

