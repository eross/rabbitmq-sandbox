package com.evross.sandbox.rmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@Component
public class GreetingHandler {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public GreetingHandler(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    private String SendMsg(String msg){
        rabbitTemplate.convertAndSend(RmqApplication.topicExchangeName, "foo.bar.baz", msg);
        return msg;
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue(SendMsg("Message from the reactive REST api!")));
    }
}