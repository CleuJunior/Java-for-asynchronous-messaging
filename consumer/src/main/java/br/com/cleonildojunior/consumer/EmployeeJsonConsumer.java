package br.com.cleonildojunior.consumer;

import br.com.cleonildojunior.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeJsonConsumer.class);
    private final ObjectMapper mapper;

    public EmployeeJsonConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @RabbitListener(queues = "employee")
    public void listen(String message) throws JsonProcessingException {
        Employee emplyee = mapper.readValue(message, Employee.class);

        LOGGER.info("Employee detail: {}", emplyee);
    }
}
