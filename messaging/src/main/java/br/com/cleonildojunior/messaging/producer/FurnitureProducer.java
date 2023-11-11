package br.com.cleonildojunior.messaging.producer;

import br.com.cleonildojunior.messaging.entity.Furniture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class FurnitureProducer {
    private final RabbitTemplate template;
    private final ObjectMapper mapper;

    public FurnitureProducer(RabbitTemplate template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public void sendMessage(Furniture furniture) throws JsonProcessingException {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("color", furniture.color());
        messageProperties.setHeader("material", furniture.material());

        String json = this.mapper.writeValueAsString(furniture);

        Message message = new Message(json.getBytes(), messageProperties);

        this.template.send("x.promotion", "", message);
    }
}