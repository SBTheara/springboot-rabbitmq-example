package com.theara.springbootrabbitmqexample.service;

import com.theara.springbootrabbitmqexample.model.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consume(User user) {
        log.info(String.format("Receive message from ADMIN is %s", user));
    }
}
