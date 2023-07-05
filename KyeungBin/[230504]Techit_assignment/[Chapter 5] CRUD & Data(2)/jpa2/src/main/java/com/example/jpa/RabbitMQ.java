package com.example.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
// !prod => not prod 라는 의미
// RabbitMQ는 테스트단계 때에만 사용하고
public class RabbitMQ implements MessageQueueInterface{

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQ.class);
    public RabbitMQ(){
        logger.info("rabbitmq component");
    }

    @Override
    public String readMessage(){
        // code for communicating with RabbitMQ
        return "message from RabbitMQ";
    }

}