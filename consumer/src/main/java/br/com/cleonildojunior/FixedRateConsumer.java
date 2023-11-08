package br.com.cleonildojunior;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
public class FixedRateConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(FixedRateConsumer.class);

    @RabbitListener(queues = "fixedrate", concurrency = "3-7")
    public void listen(String message) throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(ThreadLocalRandom.current().nextLong(1_000, 2_000));
        LOGGER.info("{} Consuming {}", Thread.currentThread().getName(), message);
    }

}
