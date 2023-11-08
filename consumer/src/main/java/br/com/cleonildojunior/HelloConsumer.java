package br.com.cleonildojunior;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloConsumer {

    @RabbitListener(queues = "hello.rmq")
    public void listen(String message) {
        System.out.println("Consuming " + message);
    }
}
