package br.com.cleonildojunior.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloRabbitProducer {
    private final RabbitTemplate template;

    public HelloRabbitProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void sendHello(String name) {
        this.template.convertAndSend("hello.rmq", "Hello  " + name);
    }
}
