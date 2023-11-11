package br.com.cleonildojunior.messaging.producer;

import br.com.cleonildojunior.messaging.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class PictureProducer2 {
    private final RabbitTemplate template;
    private final ObjectMapper mapper;

    public PictureProducer2(RabbitTemplate template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public void sendMessage(Picture picture) throws JsonProcessingException {
        String json = this.mapper.writeValueAsString(picture);

        StringBuilder sb = new StringBuilder();

        sb.append(picture.source());
        sb.append(".");

        if (picture.size() > 4_000) {
            sb.append("large");
        } else {
            sb.append("small");
        }

        sb.append(".");
        sb.append(picture.type());

        this.template.convertAndSend("x.picture2", sb.toString(), json);
    }
}