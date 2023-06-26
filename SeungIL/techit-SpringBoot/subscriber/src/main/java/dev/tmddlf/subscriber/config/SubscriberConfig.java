package dev.tmddlf.subscriber.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriberConfig {
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("boot.fanout.exchange");

    }

    @Bean
    public Queue autoGenQueue(){
        return new AnonymousQueue();
    }

    @Bean // queue와 exchange 연결해줌
    public Binding binding(
            Queue queue,
            FanoutExchange fanoutExchange
    ){
        return BindingBuilder
                .bind(queue)
                .to(fanoutExchange);
    }
}
