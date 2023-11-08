package br.com.cleonildojunior.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class FixedRateProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(FixedRateProducer.class);
    private final RabbitTemplate template;
    private int i = 0;

    public FixedRateProducer(RabbitTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 500)
    public void sendMessage() {
        i++;
        LOGGER.info("i is {}", i);
        this.template.convertAndSend("hello.rmq", "Fixed rate " + i);
    }
}
