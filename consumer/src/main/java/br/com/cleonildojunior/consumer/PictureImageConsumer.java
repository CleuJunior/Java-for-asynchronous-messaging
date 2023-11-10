package br.com.cleonildojunior.consumer;

import br.com.cleonildojunior.entity.Employee;
import br.com.cleonildojunior.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PictureImageConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PictureImageConsumer.class);
    private final ObjectMapper mapper;

    public PictureImageConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @RabbitListener(queues = "q.picture.img")
    public void listen(String message) throws JsonProcessingException {
        Picture picture = mapper.readValue(message, Picture.class);

        LOGGER.info("Picture detail: {}", picture);
    }
}
