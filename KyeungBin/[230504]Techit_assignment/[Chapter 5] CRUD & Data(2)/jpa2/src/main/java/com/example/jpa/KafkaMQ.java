package com.example.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod") // KafkaMQ는 상용단계에서 사용할 것
public class KafkaMQ implements MessageQueueInterface{

    private static final Logger logger = LoggerFactory.getLogger(KafkaMQ.class);
    public KafkaMQ(){
        logger.info("Kafkamq component");
    }

    @Override
    public String readMessage() {
        return "message from kafkamq";
    }
}
