package br.com.cleonildojunior.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class HumanResourceProducer {
    private final RabbitTemplate template;
    private final ObjectMapper mapper;

    public HumanResourceProducer(RabbitTemplate template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public void sendMessage(Employee employee) throws JsonProcessingException {
        String json = this.mapper.writeValueAsString(employee);
        this.template.convertAndSend("x.hr", "", json);
    }
}