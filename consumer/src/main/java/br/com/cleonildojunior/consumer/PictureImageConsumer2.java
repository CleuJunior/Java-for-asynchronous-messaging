package br.com.cleonildojunior.consumer;

import br.com.cleonildojunior.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PictureImageConsumer2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(PictureImageConsumer2.class);
    private final ObjectMapper mapper;

    public PictureImageConsumer2(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @RabbitListener(queues = {"q.picture.img", "q.picture.vector", "q.picture.log", "q.picture.filter"})
    public void listen(Message messageAmqp) throws JsonProcessingException {
        String jsonString = new String(messageAmqp.getBody());
        Picture picture = mapper.readValue(jsonString, Picture.class);
        LOGGER.info("Consuming picture: {} with rounting key: {}", picture, messageAmqp.getMessageProperties().getReceivedRoutingKey());
    }
}
