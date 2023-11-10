package br.com.cleonildojunior.messaging.producer;

import br.com.cleonildojunior.messaging.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class PictureProducer {
    private final RabbitTemplate template;
    private final ObjectMapper mapper;

    public PictureProducer(RabbitTemplate template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public void sendMessage(Picture picture) throws JsonProcessingException {
        String json = this.mapper.writeValueAsString(picture);
        this.template.convertAndSend("x.picture", picture.type(), json);
    }
}