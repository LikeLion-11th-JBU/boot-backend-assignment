package jym.yeongmu.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class RabbitMQ implements MesssageQueueInterface {
    @Override
    public String readMessage() {
        // code for communication with RabbitMQ
        return "message from rabbitmq";
    }
}
