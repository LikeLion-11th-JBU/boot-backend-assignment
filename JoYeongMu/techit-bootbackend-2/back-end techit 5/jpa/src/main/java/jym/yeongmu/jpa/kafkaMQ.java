package jym.yeongmu.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class kafkaMQ implements MesssageQueueInterface{
    @Override
    public String readMessage() {
        // code for communication with kafka
        return "message from kafka";
    }
}
